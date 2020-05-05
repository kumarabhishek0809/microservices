package com.kumar.registrationService.service;

import com.kumar.registrationService.dto.SellerDto;

import java.util.List;

public interface RegistrationService {


    String addSeller(SellerDto sellerDto);

    List<SellerDto> getSellersList();
}
