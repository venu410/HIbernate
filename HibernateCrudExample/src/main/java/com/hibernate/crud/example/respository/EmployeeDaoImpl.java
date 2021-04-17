package com.hibernate.crud.example.respository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hibernate.crud.example.pojo.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public void createEmployee(Employee employee) {
		
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateEmployee(Employee employee, int id) {
		// TODO Auto-generated method stub
		
	}
	
	

}
