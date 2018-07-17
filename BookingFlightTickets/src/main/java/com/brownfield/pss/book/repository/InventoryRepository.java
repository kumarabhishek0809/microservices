package com.brownfield.pss.book.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brownfield.pss.book.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

	List<Inventory> findAllByFlightNumberAndFlightDate(String flightNumber, String flightDate);
	
}
