package com.hibernate.crud.example.pojo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "Employee_Details")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@PrimaryKeyJoinColumn
	private int empId;

	@NotNull
	private String firstName;

	private String middleName;

	@NotNull
	private String lastName;

	@OneToOne(targetEntity = Address.class,cascade = CascadeType.ALL)
	private Address address;

	@NotNull
	private double salary;

	@NotNull
	private String designation;

	@OneToOne(targetEntity = Phone.class,cascade = CascadeType.ALL)
	@NotNull
	private Phone number;

	@NotNull
	@Email
	private String email;

	private String secondaryEmail;

	@NotNull
	private Date dateOfBirth;

	@NotNull
	private Date dateOfJoining;

	@NotNull
	private String maritalStatus;

}
