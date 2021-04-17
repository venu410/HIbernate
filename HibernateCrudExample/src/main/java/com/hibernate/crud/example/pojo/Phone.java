package com.hibernate.crud.example.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
@Table(name = "Emp_Phone")
public class Phone {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	
	@OneToOne(targetEntity = Employee.class)
	private Employee employee;

	@NotNull
	private String primaryNumber;
	
	private String secondaryNumber;

}
