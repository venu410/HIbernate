package com.jpa.ont.to.one.bidirectional.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.ont.to.one.bidirectional.pojo.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
