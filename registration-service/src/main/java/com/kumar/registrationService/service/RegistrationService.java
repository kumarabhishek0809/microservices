package com.kumar.registrationService.service;

import java.util.List;

import com.kumar.registrationService.model.SellerRestModel;

public interface RegistrationService {


    String addSeller(SellerRestModel sellerDto);

    List<SellerRestModel> getSellersList();
}
