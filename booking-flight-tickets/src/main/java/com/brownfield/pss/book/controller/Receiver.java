package com.brownfield.pss.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.brownfield.pss.book.component.BookingComponent;
import com.brownfield.pss.book.component.BookingStatus;

@Component
public class Receiver {
	
	BookingComponent bookingComponent;
	
	@Autowired
	public Receiver(BookingComponent bookingComponent){
		this.bookingComponent = bookingComponent;
	}

	//@RabbitListener(queues = "CheckINQ")
    public void processMessage(long bookingID ) {
		bookingComponent.updateStatus(BookingStatus.CHECKED_IN, bookingID);
    }
	
}