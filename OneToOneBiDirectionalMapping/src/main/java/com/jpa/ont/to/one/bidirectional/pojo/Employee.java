package com.jpa.ont.to.one.bidirectional.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import lombok.Data;

@Data
@Entity
@Table(name = "Emp100")
@Validated
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	@NotBlank
	@Column(name = "First_Name", nullable = false)
	@Size(min = 2,max = 20, message = "First Name Should Be 2 to 20 Charecters")
	@NotNull
	private String firstName;
	
	@NotBlank
	@Column(name = "Last_Name")
	@Size(min = 2,max = 20, message = "Last Name Should Be 2 to 20 Charecters")
	private String lastName;
	
	@NotNull
	@Column(name = "Emp_Sal")
	private float salary;
	
	@Column(name = "Emp_Email")
	@Email
	@NotBlank
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_Id",referencedColumnName = "id")
	private Address address;

}
