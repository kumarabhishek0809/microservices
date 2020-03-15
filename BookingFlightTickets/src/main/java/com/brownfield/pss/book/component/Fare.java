package com.brownfield.pss.book.component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public class Fare {
	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}

	public String getFare() {
		return fare;
	}

	public void setFare(String fare) {
		this.fare = fare;
	}

	String flightNumber;
	String flightDate;
	String fare;

	
}