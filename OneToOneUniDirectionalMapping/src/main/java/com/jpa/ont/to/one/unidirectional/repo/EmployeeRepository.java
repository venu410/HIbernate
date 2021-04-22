package com.jpa.ont.to.one.unidirectional.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.ont.to.one.unidirectional.pojo.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
