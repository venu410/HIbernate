package com.jpa.ont.to.one.unidirectional.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponse {
	
	private int statusCode;
	private String message;
	private Employee employee;

}
