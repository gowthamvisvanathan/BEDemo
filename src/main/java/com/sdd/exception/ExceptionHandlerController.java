package com.sdd.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import com.sdd.model.AppResponse;

@ControllerAdvice
public class ExceptionHandlerController {
	
	@ExceptionHandler
	public ResponseEntity<AppResponse> ResourceNotFoundException(ResourceNotFoundException e) {
		AppResponse appResponse = new AppResponse();
		appResponse.setCode(HttpStatus.NOT_FOUND.value());
		appResponse.setMessage(e.getMessage());
		// full or portions of exception can be passed in error as well.
		appResponse.setError(true);
		
		return new ResponseEntity<AppResponse>(appResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<AppResponse> internalServerError(InternalServerError e) {
		
		AppResponse appResponse = new AppResponse();
		appResponse.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		appResponse.setMessage(e.getMessage());
		// full or portions of exception can be passed in error as well.
		appResponse.setError(true);
		
		return new ResponseEntity<AppResponse>(appResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

}
