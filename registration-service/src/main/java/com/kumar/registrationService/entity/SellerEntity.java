package com.kumar.registrationService.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.kumar.registrationService.dto.Item;

import lombok.Data;

@Data
@Entity
@Table(name = "Seller")
public class SellerEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique = true)
	private String id;
	private String firstName;
	private String lastName;
	private String emailId;
	
	@Transient
	private List<Item> itemsSold;

}
