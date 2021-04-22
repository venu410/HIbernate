package com.jpa.ont.to.one.unidirectional.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(UserDetailsNotFoundException.class)
	public ResponseEntity<Object> handleUserDetailsNotFoundException(UserDetailsNotFoundException exception,
			WebRequest request) {
		ExceptionResponse response = new ExceptionResponse();
		response.setMessage("UserDetails Not Found");
		response.setStatusCode(404);
		response.setLocalDateTime(LocalDateTime.now());
		return new ResponseEntity<Object>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(IdAlreadyExistException.class)
	public ResponseEntity<Object> handleIdAlreadyExistException(IdAlreadyExistException exception, WebRequest request) {
		ExceptionResponse response = new ExceptionResponse();
		response.setStatusCode(302);
		response.setMessage("Id is Duplicate. Please enter details again");
		response.setLocalDateTime(LocalDateTime.now());
		return new ResponseEntity<Object>(response, HttpStatus.FOUND);

	}
}
