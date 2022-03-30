package com.dev.myroom.controller;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dev.myroom.entity.Employee;
import com.dev.myroom.service.EmployeeService;

@RestController
public class FireBaseController {

	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("insertEmployee")
	public String insertEmployee(@RequestBody Employee employee) throws InterruptedException, ExecutionException
	{
		return employeeService.insertEmployee(employee);
	}
	
	@GetMapping("/getEmployee/{id}")
	public Employee getEmployeeById(@PathVariable String id) throws InterruptedException, ExecutionException {
		
		return employeeService.getEmployeeById(id);	
	}
	
	@GetMapping("/getAllemployees")
	public List<Employee> getAllemployees() throws InterruptedException, ExecutionException {
		
		return employeeService.getAllEmployees();
	}
	
	@PostMapping("/getByIdAndName")
	public List<Employee> getByIdAndName(@RequestBody Employee employee) throws InterruptedException, ExecutionException {
		
		 return employeeService.getByIdAndName(employee);
	}
	
	@PutMapping("/updateEmployee")
	public String updateEmployee(@RequestBody Employee employee) throws InterruptedException, ExecutionException
	{
		return employeeService.updateEmployee(employee);
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable String id) throws InterruptedException, ExecutionException {
		
		return employeeService.deleteEmployee(id);	
	}
}
