package com.jpa.ont.to.one.bidirectional.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import lombok.Data;

@Data
@Entity
@Table(name = "Employee_Address")
@Validated
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
	
	@OneToOne(mappedBy = "address", cascade = CascadeType.ALL)
	private Employee employee;
	
	
	
	
}
