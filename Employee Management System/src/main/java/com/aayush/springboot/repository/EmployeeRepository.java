package com.aayush.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aayush.springboot.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
// JpaRepository internally provides @Repository and @Transactional annotations, hence we don't need to add them manually
	
	
}
