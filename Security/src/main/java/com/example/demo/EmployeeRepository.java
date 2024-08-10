package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	public Optional<Employee> findByEmail(String email);
	
	public List<Employee> findAllByDepartment(int department);
}
