package com.example.demo;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "product-service", url = "localhost:9898/auth")
public interface EmployeeClient
{
	@GetMapping("/admin/")
	public List<Employee> findAllByDepartment (@RequestParam("department") int department);
}
