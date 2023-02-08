package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.EmployeeDao;
import com.example.entity.Employee;

@Service
public class EmployeeServiceImp implements EmployeeService{
	@Autowired
	private EmployeeDao dao;

	@Override
	public String addEmployee(Employee emp) {
		dao.save(emp);
		return "Employee data saved msg from service";
	}

	@Override
	public List<Employee> getEmployee() {
		List<Employee> emplist=dao.findAll();
		return emplist;
	}

	@Override
	public String updateEmployee(Employee emp) {
		dao.save(emp);
		return "Employee updated msg from service";
	}

	@Override
	public String deleteEmployee(Integer id) {
		dao.deleteById(id);
		return "Employee deleted msg from service";
	}

	@Override
	public Optional<Employee> getEmployeeById(Integer id) {
		Optional<Employee> emp=dao.findById(id);
		return emp;
		
	}

	@Override
	public String deleteAllEmployee() {
		dao.deleteAll();
		return "All employee deleted msg from service";
	}
	
	public String addMultipleEmployee(List<Employee> emp) {
		dao.saveAll(emp);
		return "Employees data saved msg from service";
	}

}
