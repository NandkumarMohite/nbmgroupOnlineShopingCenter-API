package com.nbmgroup.onlinemobileshop.Exception;


import java.io.Serializable;



import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class ServiceException extends Exception implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String errorMessage;
	
	public ServiceException() {

	}

	public ServiceException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}