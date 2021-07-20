package com.kumar.registrationService.core.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessage {

	private Date timeStamp;
	private String errorMessage;
}
