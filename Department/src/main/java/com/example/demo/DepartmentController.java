package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/department")
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping ("/admin/")
	public Department add(@RequestBody Department department) {
		return departmentService.add(department);
	}
	
	@GetMapping ("/")
	public List<Department> findAll() {
		return departmentService.findAll();
	}
	
	@GetMapping("/{id}")
	public Department findById(@PathVariable int id) {
		return departmentService.findById(id);
	}
	
	@GetMapping ("/admin/")
	public List<Employee> findAll(@RequestParam int department) {
		return departmentService.findAllByDepartment(department);
	}
}
