package com.emp_mng.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp_mng.entities.Manager;
//mport com.emp_mng.entities.User;

public interface ManagerRepository extends JpaRepository<Manager,Integer> {

}
