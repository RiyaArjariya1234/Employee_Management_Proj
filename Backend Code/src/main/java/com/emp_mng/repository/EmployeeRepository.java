package com.emp_mng.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp_mng.entities.Employee;
//import com.emp_mng.entities.User;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
