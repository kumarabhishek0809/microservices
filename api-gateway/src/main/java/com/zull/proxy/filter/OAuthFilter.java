package com.zull.proxy.filter;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class OAuthFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(OAuthFilter.class);

	@Autowired
	private RestTemplate restTemplate;

	public String filterType() {

		return "pre";
	}

	public int filterOrder() {

		return 1;
	}

	public boolean shouldFilter() {

		return true;
	}

	public Object run() {

		RequestContext requestContext = RequestContext.getCurrentContext();
		HttpServletRequest request = requestContext.getRequest();

		// Avoid checking for authentication for the token endpoint
		if (request.getRequestURI().startsWith("/token")) {
			return null;
		}

		// Get the value of the Authorization header.
		String authHeader = request.getHeader("Authorization");

		// If the Authorization header doesn't exist or is not in a valid format.
		if (StringUtils.isEmpty(authHeader)) {
			log.error("No auth header found");
			// Send error to client
			handleError(requestContext);
			return null;
		} else if (authHeader.split("Bearer ").length != 2) { // Executing Throttling Filter
			log.error("Invalid auth header");
			// Send error to client
			handleError(requestContext);
			return null;
		}

		// Get the value of the token by splitting the Authorization header
		String token = authHeader.split("Bearer ")[1];

		// https://www.baeldung.com/rest-template
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.add("Authorization", "Basic YXBwbGljYXRpb24xOmFwcGxpY2F0aW9uMXNlY3JldA==");
		
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		

		HttpEntity<MultiValueMap<String, String>> requestCall = new HttpEntity<>(map, headers);

		ResponseEntity<String> response = restTemplate
				.postForEntity("http://TOKEN-SERVICE/oauth/check_token?token=" + token, requestCall, String.class);

		// If the authorization server doesn't respond with a 200.
		if (!response.getStatusCode().equals(HttpStatus.OK)) {
			log.error("Response code from authz server is " + response.getStatusCode());
			handleError(requestContext);
		}

		return null;
	}

	private void handleError(RequestContext requestContext) {
		requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
		requestContext.setResponseBody("{\"error\": true, \"reason\":\"Authentication Failed\"}");
		requestContext.setSendZuulResponse(false);
	}
}
