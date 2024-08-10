package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private EmployeeClient employeeClient;
	
	public List<Department> findAll() {
		return departmentRepository.findAll();
	}
	
	public Department findById(int id) {
		return departmentRepository.findById(id).orElse(null);
	}
	
	public Department add(Department department) {
		return departmentRepository.save(department);
	}
	
	public List<Employee> findAllByDepartment(int department) {
		return employeeClient.findAllByDepartment(department);
	}
}
