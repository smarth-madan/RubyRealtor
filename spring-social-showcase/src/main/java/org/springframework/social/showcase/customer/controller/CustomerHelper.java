package org.springframework.social.showcase.customer.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.datasource.DataSourceUtils;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import org.springframework.social.showcase.customer.model.*;

public class CustomerHelper {

	private DataSource mysqldataSource;
	private Connection connection;
	private JdbcTemplate jdbctemplate;
	private SimpleJdbcInsert	jdbcInsert;
	
	public CustomerHelper(DataSource mysqldataSource) {
		this.mysqldataSource = mysqldataSource;
		this.jdbctemplate = new JdbcTemplate(mysqldataSource);
	}
	
	
	public List<Customer> findAllCustomers() {
	    try{
	    	return this.jdbctemplate.query( "select * from Customer", new CustomerMapper());
	    }catch(DataAccessException de){
	    	de.printStackTrace();
	    	System.out.println("ERROR :" +  de.getMessage());
	    	return null;
	    }
		
	}

	private static final class CustomerMapper implements RowMapper<Customer> {

	    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
	        Customer customer = new Customer();
	        customer.setC_id(rs.getString("C_ID"));
	        customer.setfName(rs.getString("fName"));
	        customer.setlName(rs.getString("lName"));
	        customer.setStreet(rs.getString("street"));
	        customer.setCity(rs.getString("city"));
	        customer.setState(rs.getString("State"));
	        customer.setZipcode(rs.getString("zipcode"));
	        customer.setMartial_status(rs.getString("marital_status"));
	        customer.setSalary_range(rs.getString("salary_range"));
	        customer.setEmail_ID(rs.getString("email_ID"));
	        customer.setPhone_number(rs.getString("phone_number"));
	        customer.setR_ID(rs.getString("R_ID"));
	        customer.setCR_ID(rs.getString("CR_ID"));
	        return customer;
	    }        
	}
}
