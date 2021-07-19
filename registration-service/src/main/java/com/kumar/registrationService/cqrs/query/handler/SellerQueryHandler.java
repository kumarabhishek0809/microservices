package com.kumar.registrationService.controller.query.handler;

import java.util.ArrayList;
import java.util.List;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import com.kumar.registrationService.controller.query.model.SellerRestModel;
import com.kumar.registrationService.query.FindSellerQuery;
import com.kumar.registrationService.repository.SellerRepository;

@Component
public class SellerQueryHandler {

	private final SellerRepository repository;

	public SellerQueryHandler(SellerRepository repository) {
		this.repository = repository;
	}
	
	@QueryHandler
	public List<SellerRestModel> findSellers(FindSellerQuery findSellerQuery){
		ArrayList<Object> arrayList = new ArrayList<>();
		return null;
	}

}
