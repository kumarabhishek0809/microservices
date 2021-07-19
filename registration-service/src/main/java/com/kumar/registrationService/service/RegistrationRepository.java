package com.kumar.registrationService.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kumar.registrationService.model.SellerRestModel;


@Repository
public class RegistrationRepository {

    List<SellerRestModel> sellerDtoList = new ArrayList<>();

    public boolean addSeller(SellerRestModel sellerDto) {

        return sellerDtoList.add(sellerDto);
    }

    public List<SellerRestModel> getSellerList() {
        return sellerDtoList;
    }
}
