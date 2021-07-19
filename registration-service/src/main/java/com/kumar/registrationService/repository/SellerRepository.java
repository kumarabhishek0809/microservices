package com.kumar.registrationService.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kumar.registrationService.entity.SellerEntity;

public interface SellerRepository extends JpaRepository<SellerEntity, String>{

	Optional<SellerEntity> findById(String sellerId);
}
