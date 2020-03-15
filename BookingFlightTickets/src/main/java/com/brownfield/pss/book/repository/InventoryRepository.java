package com.brownfield.pss.book.repository;


import com.brownfield.pss.book.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

	List<Inventory> findAllByFlightNumberAndFlightDate(String flightNumber, String flightDate);
	
}
