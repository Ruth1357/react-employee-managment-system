package com.springbootbackend.employeemanagment.controller;

import java.util.ArrayList;
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

import com.springbootbackend.employeemanagment.domain.Employee;
import com.springbootbackend.employeemanagment.service.EmployeeService;
@CrossOrigin("*")
@RestController
@RequestMapping("/services")
public class controller {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/getEmployees")
	public List<Employee> getEmployeeList(){
				
		return employeeService.getEmployees();
	}
	
	@PostMapping("/getEmployees")
    public void createEmployee(@RequestBody Employee employee) {
         employeeService.save(employee);
    }
	
	 @DeleteMapping("/getEmployees/{id}")
    public void deletemployee(@PathVariable String id) {
         employeeService.delete(id);
    }
	 
	 @PutMapping("/getEmployees/{id}")
	    public void updateEmployee(@PathVariable String id,@RequestBody Employee employee) {
	         employeeService.updateEmployee(id,employee);
	    }
	 
	 @GetMapping("/getEmployees/{id}")
		public Employee getEmployeeList(@PathVariable String id){
					
			return employeeService.getEmployeeById(id);
		}
		
	
}
