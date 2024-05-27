package com.emp_mng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class EmpMangProjApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpMangProjApplication.class, args);
	}

}
