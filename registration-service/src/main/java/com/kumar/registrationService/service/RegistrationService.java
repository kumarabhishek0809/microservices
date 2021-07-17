package com.kumar.registrationService.service;

import com.kumar.registrationService.dto.SellerDTO;

import java.util.List;

public interface RegistrationService {


    String addSeller(SellerDTO sellerDto);

    List<SellerDTO> getSellersList();
}
