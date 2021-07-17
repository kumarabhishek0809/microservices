package com.kumar.registrationService.entity;

import java.io.Serializable;
import java.util.List;

import com.kumar.registrationService.dto.Item;

import lombok.Data;

@Data
public class SellerEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String firstName;
	private String lastName;
	private String emailId;
	private List<Item> itemsSold;

}
