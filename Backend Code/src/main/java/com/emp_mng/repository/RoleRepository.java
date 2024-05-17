package com.emp_mng.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp_mng.entities.UserRole;

public interface RoleRepository extends JpaRepository<UserRole, Integer> {
}

