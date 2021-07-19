package com.kumar.registrationService.cqrs.query.handler;

import java.util.ArrayList;
import java.util.List;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.kumar.registrationService.cqrs.query.FindSellerQuery;
import com.kumar.registrationService.entity.SellerEntity;
import com.kumar.registrationService.model.SellerRestModel;
import com.kumar.registrationService.repository.SellerRepository;

@Component
public class SellerQueryHandler {

	private final SellerRepository repository;

	public SellerQueryHandler(SellerRepository repository) {
		this.repository = repository;
	}

	@QueryHandler
	public List<SellerRestModel> findSellers(FindSellerQuery findSellerQuery) {
		List<SellerRestModel> sellers = new ArrayList<>();
		List<SellerEntity> findAll = repository.findAll();
		for (SellerEntity se : findAll) {
			SellerRestModel sellerRestModel = new SellerRestModel();
			BeanUtils.copyProperties(se, sellerRestModel);
			sellers.add(sellerRestModel);
		}
		return sellers;
	}

}
