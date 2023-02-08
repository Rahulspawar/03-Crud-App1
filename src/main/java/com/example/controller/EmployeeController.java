package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Employee;
import com.example.service.EmployeeServiceImp;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeServiceImp employeeService;
	
	@PostMapping("/addemp")
	public ResponseEntity<String> addEmployee(@RequestBody Employee emp)
	{
		String msg=employeeService.addEmployee(emp);
		//String msg="Data saved msg from controller";
		return new ResponseEntity<>(msg,HttpStatus.CREATED);	
	}
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getEmployee()
	{
		List<Employee> emplist=employeeService.getEmployee();  //here we are getting 1 by 1 object of list
		return new ResponseEntity<List<Employee>>(emplist,HttpStatus.OK);   //that object we are passing here	
	}
	
	@PutMapping("/updateemp")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee emp)
	{
		String msg=employeeService.updateEmployee(emp);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteemp")
	public ResponseEntity<String> deleteEmployee(@RequestParam("empid") Integer id)
	{
		String msg=employeeService.deleteEmployee(id);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
		
	}
	
	@GetMapping("/getempbyid/{empid}")
	public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable("empid") Integer id)
	{
		Optional<Employee> emp=employeeService.getEmployeeById(id);
		return new ResponseEntity<Optional<Employee>>(emp,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteall")
	public ResponseEntity<String> deleteAllEmployee()
	{
		String msg=employeeService.deleteAllEmployee();
		return  new ResponseEntity<String>(msg,HttpStatus.OK);	
	}
	
	@PostMapping("/addmulemp")
	public ResponseEntity<String> addMultipleEmployee(@RequestBody List<Employee> emp)
	{
		String msg=employeeService.addMultipleEmployee(emp);
		return new ResponseEntity<>(msg,HttpStatus.CREATED);	
	}

}
