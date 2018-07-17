package com.zull.proxy.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class CustomZuulFilter extends ZuulFilter{

	@Override
	public boolean shouldFilter() {
		RequestContext currentContext = RequestContext.getCurrentContext();
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		System.out.println("This Request is in Custom Zull Filter");
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;
	}

}
