package com.springbootbackend.employeemanagment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootbackend.employeemanagment.domain.Employee;
import com.springbootbackend.employeemanagment.repo.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepo employeeRepo;

	public List<Employee> getEmployees() {
		return employeeRepo.getEmployees();
		
		
	}

	public void save(Employee employee) {
		// TODO Auto-generated method stub
		 employeeRepo.save(employee);
	}

	public void delete(String id) {
		employeeRepo.delete(id);
		
	}

	public void updateEmployee(String id, Employee employee) {
		
		employeeRepo.updateEmployee(id,employee);
	}

	public Employee getEmployeeById(String id) {
		// TODO Auto-generated method stub
		return employeeRepo.getEmployeeById(id);
	}
	
	
}
