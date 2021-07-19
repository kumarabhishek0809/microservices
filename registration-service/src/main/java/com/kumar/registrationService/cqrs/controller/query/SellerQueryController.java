package com.kumar.registrationService.controller.query;

import java.util.List;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kumar.registrationService.controller.query.model.SellerRestModel;
import com.kumar.registrationService.query.FindSellerQuery;

@RestController
@RequestMapping("/sellers")
public class SellerQueryController {

	@Autowired
	QueryGateway queryGateway;

	@GetMapping
	public ResponseEntity<List<SellerRestModel>> getSellers() {
		FindSellerQuery findSellerQuery = new FindSellerQuery();
		List<SellerRestModel> sellers = queryGateway //
				.query(findSellerQuery, ResponseTypes.multipleInstancesOf(SellerRestModel.class)) //
				.join();
		return new ResponseEntity<List<SellerRestModel>>(sellers, HttpStatus.OK);

	}

}
