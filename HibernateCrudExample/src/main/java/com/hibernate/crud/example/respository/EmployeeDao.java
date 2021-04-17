package com.hibernate.crud.example.respository;

import java.util.List;

import com.hibernate.crud.example.pojo.Employee;

public interface EmployeeDao {

	public void createEmployee(Employee employee);

	public List<Employee> getAllEmployees();

	public void deleteEmployee(int id);

	public Employee getEmployeeById(int id);

	public void updateEmployee(Employee employee, int id);
}
