package com.OrderMicroService.exception;

/**
 * 
 * @author Sandeep Kumar will handle the Header request exception
 *
 */
public class InvalidHeaderFieldException extends RuntimeException {

	String message;

	public InvalidHeaderFieldException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
