package com.springbootbackend.employeemanagment.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
private String id;
private String emailId;
private String firstName;
private String lastName;
public Employee() {
    
 
}

public Employee(String id, String emailId, String firstName, String lastName) {
    
    this.id = id;
    this.emailId = emailId;
    this.firstName = firstName;
    this.lastName = lastName;
}

public String getId() {
	return this.id;
	
}
public String getEmailId() {
	return this.emailId;
	
}
public String getFirstName() {
	return this.firstName;
	
}
public String getLastName() {
	return this.lastName;
	
}

public void setId(String id) {
	this.id=id;
	
}
public void setEmailId(String emailId) {
	this.emailId=emailId;
	
}
public void setFirstName(String firstName) {
	this.firstName=firstName;
	
}
public void setLastName(String lastName) {
	this.lastName=lastName;
	
}


}
