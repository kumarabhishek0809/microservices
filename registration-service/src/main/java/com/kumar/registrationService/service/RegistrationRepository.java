package com.kumar.registrationService.service;

import com.kumar.registrationService.dto.SellerDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class RegistrationRepository {

    List<SellerDTO> sellerDtoList = new ArrayList<>();

    public boolean addSeller(SellerDTO sellerDto) {

        return sellerDtoList.add(sellerDto);
    }

    public List<SellerDTO> getSellerList() {
        return sellerDtoList;
    }
}
