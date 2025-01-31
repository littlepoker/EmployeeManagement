package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/auth")
@CrossOrigin
public class AuthenticationController {
	@Autowired
	private AuthenticationService authService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping ("/register")
	public void register(@RequestBody Employee employee) {
		authService.register(employee);
	}
	
	
	@PostMapping ("/login")
	public String login(@RequestBody AuthenticationRequest request) {
		return authService.login(request);
	}
	
	@PostMapping("/validate")
	public String validate(@RequestParam("token") String jwtToken)
	{
		System.out.println(jwtToken);
		return authService.validate(jwtToken)
				.toString();
	}
	
	@PostMapping ("/logout")
	public void logout(@RequestParam("token") String JwtToken) {
		authService.logout(JwtToken);
	}
	
	@GetMapping ("/admin/")
	public List<Employee> findAllByDepartment(@RequestParam("department") int department) {
		return employeeService.findAllByDepartment(department);
	}
	
	@GetMapping ("/admin/employee")
	public List<Employee> findAll() {
		return employeeService.findAll();
	}
}