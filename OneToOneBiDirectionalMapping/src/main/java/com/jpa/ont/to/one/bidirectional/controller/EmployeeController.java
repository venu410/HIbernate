package com.jpa.ont.to.one.bidirectional.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.ont.to.one.bidirectional.config.DataConvertUtil;
import com.jpa.ont.to.one.bidirectional.exception.UserDetailsNotFoundException;
import com.jpa.ont.to.one.bidirectional.pojo.AllEmployeeResponse;
import com.jpa.ont.to.one.bidirectional.pojo.Employee;
import com.jpa.ont.to.one.bidirectional.pojo.EmployeeResponse;
import com.jpa.ont.to.one.bidirectional.repo.EmployeeRepository;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@Validated
public class EmployeeController {

	@Autowired
	EmployeeRepository repository;

	@ApiOperation(httpMethod = "POST", value = "Save Employee Details", notes = "Return Employee Response", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, response = EmployeeResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 200, message = "Bad Request"),
			@ApiResponse(code = 401, message = "Authuntication Failed"),
			@ApiResponse(code = 404, message = "Service Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "HTTP_AUTH_TOKEN", required = false, dataType = "String", paramType = "header", value = "API Gateway - JWT Token") })
	@PostMapping("/save")
	public ResponseEntity<EmployeeResponse> saveEmployee(@Valid @RequestBody Employee employee) {
		log.info("Enter Into a saveEmployee() method");
		EmployeeResponse response = new EmployeeResponse();
		Employee emp = repository.save(employee);
		if (emp != null) {
			log.info("Saved Employee Object Is: {}", DataConvertUtil.toJson(emp));
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setEmployee(emp);
		} else {
			response.setMessage("Internal Error!");
			response.setStatusCode(500);

		}
		log.info("Save Employee Response {}", DataConvertUtil.toJson(emp));
		log.info("Exit From saveEmployee() method");

		return new ResponseEntity<EmployeeResponse>(response, HttpStatus.OK);

	}

	@ApiOperation(httpMethod = "GET", value = "Get List Of Employee Details", notes = "Return Employee Response", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, response = AllEmployeeResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 200, message = "Bad Request"),
			@ApiResponse(code = 401, message = "Authuntication Failed"),
			@ApiResponse(code = 404, message = "Service Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "HTTP_AUTH_TOKEN", required = false, dataType = "String", paramType = "header", value = "API Gateway - JWT Token") })
	@GetMapping("/getAllEmployees")
	public ResponseEntity<AllEmployeeResponse> getAllEmployees() {
		log.info("Enter Into a getAllEmployees() method");
		AllEmployeeResponse response = new AllEmployeeResponse();
		List<Employee> employees = repository.findAll();
		if (employees.isEmpty() || employees == null) {
			throw new UserDetailsNotFoundException();
		} else {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setEmployee(employees);
		}
		log.info("Save Employee Response {}", DataConvertUtil.toJson(response));
		log.info("Exit From saveEmployee() method");
		return new ResponseEntity<AllEmployeeResponse>(response, HttpStatus.OK);
	}

	@ApiOperation(httpMethod = "GET", value = "Save Employee Details", notes = "Return Employee Response", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, response = EmployeeResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 200, message = "Bad Request"),
			@ApiResponse(code = 401, message = "Authuntication Failed"),
			@ApiResponse(code = 404, message = "Service Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "HTTP_AUTH_TOKEN", required = false, dataType = "String", paramType = "header", value = "API Gateway - JWT Token") })
	@PostMapping("/getEmployeeById/{id}")
	public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable("id") Long id) {
		log.info("Enter Into a getEmployeeById() method");
		EmployeeResponse response = new EmployeeResponse();
		Optional<Employee> emp = repository.findById(id);
		if (emp.isPresent()) {
			log.info("Saved Employee Object Is: {}", DataConvertUtil.toJson(emp));
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setEmployee(emp.get());
		} else {
			throw new UserDetailsNotFoundException();
		}
		log.info("Save Employee Response {}", DataConvertUtil.toJson(emp));
		log.info("Exit From getEmployeeById() method");

		return new ResponseEntity<EmployeeResponse>(response, HttpStatus.OK);

	}

	@ApiOperation(httpMethod = "DELETE", value = "Save Employee Details", notes = "Return Employee Response", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, response = EmployeeResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 200, message = "Bad Request"),
			@ApiResponse(code = 401, message = "Authuntication Failed"),
			@ApiResponse(code = 404, message = "Service Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "HTTP_AUTH_TOKEN", required = false, dataType = "String", paramType = "header", value = "API Gateway - JWT Token") })
	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<EmployeeResponse> deleteEmployeeById(@PathVariable("id") Long id) {
		log.info("Enter Into a deleteEmployeeById() method");
		EmployeeResponse response = new EmployeeResponse();
		try {
			repository.deleteById(id);
			response.setStatusCode(200);
			response.setMessage("Success");
		} catch (Exception e) {
			throw new UserDetailsNotFoundException();
		}
		log.info("Exit From deleteEmployeeById() method");

		return new ResponseEntity<EmployeeResponse>(response, HttpStatus.OK);

	}

	@ApiOperation(httpMethod = "PUT", value = "Update User", notes = "Return Saved User Response", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, response = EmployeeResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 200, message = "Bad Request"),
			@ApiResponse(code = 401, message = "Authuntication Failed"),
			@ApiResponse(code = 404, message = "Service Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "HTTP_AUTH_TOKEN", required = false, dataType = "String", paramType = "header", value = "API Gateway - JWT Token") })
	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity<EmployeeResponse> updateEmployee(@PathVariable("id") Long id,
			@RequestBody Employee employee) {
		log.info("Enter into updateEmployee() method");
		EmployeeResponse response = new EmployeeResponse();
		Optional<Employee> employeeDetails = repository.findById(id);
		if (employeeDetails.isPresent()) {
			Employee existingDetails = new Employee();

			// Update Only Address and Email
			existingDetails.setAddress(employee.getAddress());
			existingDetails.setEmail(employee.getEmail());

			existingDetails.setFirstName(employeeDetails.get().getFirstName());
			existingDetails.setLastName(employeeDetails.get().getLastName());
			existingDetails.setSalary(employeeDetails.get().getSalary());
			if (id == existingDetails.getId()) {
				existingDetails.setId(employeeDetails.get().getId());
			}

			repository.save(existingDetails);

			setResponse(existingDetails, response);

			log.info("Updated User {}", DataConvertUtil.toJson(existingDetails));
		} else {
			throw new UserDetailsNotFoundException();
		}
		log.info("Exit from updateEmployee() method");
		return new ResponseEntity<EmployeeResponse>(response, HttpStatus.OK);

	}

	private void setResponse(Employee existingDetails, EmployeeResponse response) {
		response.setEmployee(existingDetails);
		response.setMessage("Employee updated Successfully!");
		response.setStatusCode(200);

	}

}
