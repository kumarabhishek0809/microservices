package com.brownfield.pss.checkin.component;

import java.util.Date;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.brownfield.pss.checkin.constants.BookingStatus;
import com.brownfield.pss.checkin.controller.Sender;
import com.brownfield.pss.checkin.dto.BookingRecord;
import com.brownfield.pss.checkin.entity.CheckInRecord;
import com.brownfield.pss.checkin.repository.CheckinRepository;

@Component
public class CheckinComponent {
	private static final Logger logger = LoggerFactory.getLogger(CheckinComponent.class);
	private static final String bookingURL = "http://localhost:7071/booking";
	
	@Autowired
	private RestTemplate restTemplate; 

	CheckinRepository checkinRepository;
	Sender sender;

	@Autowired
	public CheckinComponent(CheckinRepository checkinRepository, Sender sender) {
		this.checkinRepository = checkinRepository;
		this.sender = sender;
	}

	public long checkIn(CheckInRecord checkIn) {
		long bookingId = checkIn.getBookingId();
		BookingRecord bookingRecord = null;
		try {
			logger.info("calling booking to get booking information for booking id " + bookingId);
			bookingRecord = restTemplate.getForObject(bookingURL + "/get/" + bookingId, BookingRecord.class);

			if (bookingRecord != null) { // booking existed
				if (bookingRecord.getStatus().equals(BookingStatus.CHECKED_IN)) { // already checked in
					return -2;
				} else {
					logger.info("Booking info is " + bookingRecord.toString());
					checkIn.setCheckInTime(new Date());
					logger.info("Saving checkin ");
					long checkInId = checkinRepository.save(checkIn).getId(); //Modified by Kumar
					logger.info("Successfully saved checkin ");
					// send a message back to booking to update status
					logger.info("Sending booking id " + bookingId);
					//sender.send(bookingId);
					return checkInId; //Added by Kumar
				}
			} else { // In case of wrong booking id
				return -1;
			}
		} catch (Exception e) {
			logger.error("BOOKING SERVICE IS NOT AVAILABLE");
			e.printStackTrace();
			System.exit(0);
		}
		return bookingId;
	}

	public CheckInRecord getCheckInRecord(long id) {
		CheckInRecord entity = new CheckInRecord();                         
		entity.setId(id);                          
		Example<CheckInRecord> example = Example.of(entity);
		Optional<CheckInRecord> findOne = checkinRepository.findOne(example);
		return findOne.get();
	}

}
