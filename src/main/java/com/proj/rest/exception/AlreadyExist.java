package com.proj.rest.exception;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AlreadyExist extends RuntimeException {
	private static Logger LOGGER = LogManager.getLogger(AlreadyExist.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public AlreadyExist(String message) {
		super(message);
		LOGGER.debug(">>>>>>>>>>Cotrol comes in AlreadyExist constructor<<<<<<<<<<");
		
	}
	

}
