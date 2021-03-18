package com.proj.rest.exception;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
	private static Logger LOGGER = LogManager.getLogger(ResourceNotFoundException.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String message) {
		super(message);
		LOGGER.debug(">>>>>>>>Control flow comes in updateUser method in resource not found exception >>>>>>>>>>" );		
	}

}
