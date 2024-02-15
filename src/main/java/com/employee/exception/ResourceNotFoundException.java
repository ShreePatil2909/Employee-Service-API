package com.employee.exception;

public class ResourceNotFoundException extends RuntimeException {

	String message = "Invalide Employee Details..!!";
	
	public ResourceNotFoundException(String message) {
		super(message);
	}

}
