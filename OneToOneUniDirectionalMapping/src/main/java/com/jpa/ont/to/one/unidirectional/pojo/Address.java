package com.jpa.ont.to.one.unidirectional.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "Employee_Address")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@Column(name = "Emp_Add1")
	private String add1;
	
	@NotNull
	@Column(name = "Emp_Add2")
	private String add2;
	
	@NotNull
	@Column(name = "Emp_City")
	private String city;
	
	@NotNull
	@Column(name = "Emp_State")
	private String state;
	
	@NotNull
	@Column(name = "Emp_ZipCode")
	private String pincode;
	
	
	
	
}
