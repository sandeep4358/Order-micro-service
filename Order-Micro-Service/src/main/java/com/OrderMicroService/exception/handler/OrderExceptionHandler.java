package com.OrderMicroService.exception.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.OrderMicroService.exception.InvalidFieldException;
import com.OrderMicroService.exception.InvalidHeaderFieldException;

@RestControllerAdvice
public class OrderExceptionHandler {
	Logger log =  LoggerFactory.getLogger(OrderExceptionHandler.class);
	
	@ExceptionHandler	
	public String handleInvalidFieldException(InvalidFieldException exception) {
		log.debug("Excepiton handled with invalid filed");
		return exception.getMessage();	
	}
	
	@ExceptionHandler
	public ResponseEntity<String> handleResponeHeaderException(InvalidHeaderFieldException exception){
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.PRECONDITION_FAILED);
	}
}
