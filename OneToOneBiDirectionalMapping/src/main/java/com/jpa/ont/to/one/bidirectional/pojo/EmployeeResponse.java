package com.jpa.ont.to.one.bidirectional.pojo;

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
	private Address address;

}
