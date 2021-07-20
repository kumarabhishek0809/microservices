package com.kumar.registrationService.core.exception;

import java.util.Date;

import org.axonframework.common.AxonException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class SellerServiceErrorHandler {

	@ExceptionHandler(value = { IllegalStateException.class })
	public ResponseEntity<ErrorMessage> handleIllegalStateException(IllegalStateException exception, WebRequest request) {
		return new ResponseEntity<>(new ErrorMessage(new Date(),exception.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<ErrorMessage> handleException(Exception exception, WebRequest request) {
		return new ResponseEntity<>(new ErrorMessage(new Date(),exception.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = { AxonException.class })
	public ResponseEntity<ErrorMessage> handleAxonException(AxonException exception, WebRequest request) {
		return new ResponseEntity<>(new ErrorMessage(new Date(),exception.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
