package com.springbootbackend.employeemanagment.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.springbootbackend.employeemanagment.domain.Employee;

@Repository
public class EmployeeRepo {
	@Autowired 
	private NamedParameterJdbcTemplate jdbcTemplate;

	public List<Employee> getEmployees() {
	SqlParameterSource params=new MapSqlParameterSource();
		return this.jdbcTemplate.query("SELECT id id, first_name firstName, last_name lastName, email_id emailId\r\n"
				+ "FROM public.employee;", params,new BeanPropertyRowMapper<>(Employee.class));
	}

	public void save(Employee employee) {
		// TODO Auto-generated method stub
		SqlParameterSource params=new MapSqlParameterSource()
				.addValue("firstName", employee.getFirstName())
				.addValue("emailId", employee.getEmailId())
				.addValue("lastName", employee.getLastName());
		this.jdbcTemplate.update("insert into public.employee (id,first_name,last_name,email_id)\r\n"
				+ "values((select max(id)+1 from public.employee),:firstName,:lastName,:emailId);", params);
	}

	public void delete(String id) {
		SqlParameterSource params=new MapSqlParameterSource()
				.addValue("id", Integer.valueOf(id));
		this.jdbcTemplate.update("delete from public.employee where id=:id",params);
		
	}

	public void updateEmployee(String id, Employee employee) {
		SqlParameterSource params=new MapSqlParameterSource()
				.addValue("firstName", employee.getFirstName())
				.addValue("emailId", employee.getEmailId())
				.addValue("id", Integer.valueOf(id))
				.addValue("lastName", employee.getLastName());
		this.jdbcTemplate.update("update public.employee \r\n"
				+ "set email_id =:emailId ,first_name =:firstName,last_name =:lastName\r\n"
				+ "where id=:id",params);
	}

	public Employee getEmployeeById(String id) {
		SqlParameterSource params=new MapSqlParameterSource()
				.addValue(id, Integer.valueOf(id));
		 return this.jdbcTemplate.queryForObject("SELECT id id, first_name firstName, last_name lastName, email_id emailId\r\n"
					+ "FROM public.employee where id=:id;",params,new BeanPropertyRowMapper<>(Employee.class));
	}
	
	
}

	
	
