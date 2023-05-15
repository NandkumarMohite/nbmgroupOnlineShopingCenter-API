package com.nbmgroup.onlinemobileshop.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends ServiceException {

	private static final long serialVersionUID = 1L;
	
	private String errorMessage;
	
	public BadRequestException() {

	}

	public BadRequestException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}