package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.entity.Employee;

public interface EmployeeService {
	public String addEmployee(Employee emp);
	public List<Employee> getEmployee();
	public String updateEmployee(Employee emp);
	public String deleteEmployee(Integer id);
	public Optional<Employee> getEmployeeById(Integer id);
	public String deleteAllEmployee();
	public String addMultipleEmployee(List<Employee> emp);
}
