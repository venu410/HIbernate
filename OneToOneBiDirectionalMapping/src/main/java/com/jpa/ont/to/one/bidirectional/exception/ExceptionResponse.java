package com.jpa.ont.to.one.bidirectional.exception;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ExceptionResponse {

	private String message;
	private int statusCode;
	private LocalDateTime localDateTime;

}
