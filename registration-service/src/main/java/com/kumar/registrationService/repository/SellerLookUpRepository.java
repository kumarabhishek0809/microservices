package com.kumar.registrationService.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kumar.registrationService.entity.SellerLookUpEntity;

public interface SellerLookUpRepository extends JpaRepository<SellerLookUpEntity, String>{

	Optional<SellerLookUpEntity> findById(String sellerId);
}
