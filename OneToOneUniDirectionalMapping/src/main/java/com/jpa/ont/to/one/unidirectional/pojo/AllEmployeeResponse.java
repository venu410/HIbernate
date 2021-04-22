package com.jpa.ont.to.one.unidirectional.pojo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllEmployeeResponse {
	
	private int statusCode;
	private String message;
	private List<Employee> employee;

}
