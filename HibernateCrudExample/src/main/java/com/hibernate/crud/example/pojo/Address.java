package com.hibernate.crud.example.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "Emp_Address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	
	@OneToOne(targetEntity = Employee.class)
	private Employee employee;
	
	@Column(name = "Employee_HNO")
	private String h_No;
	
	@Column(name = "Employee_StrName")
	private String streetName;
	
	@Column(name = "Employee_Area")
	private String areaName;
	
	@Column(name = "Employee_City")
	private String city;
	
	@Column(name = "Employee_State")
	private String state;
	
	@Column(name = "Employee_Zip")
	private String zipCode;
	
	
}
