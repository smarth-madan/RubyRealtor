package org.springframework.social.showcase.customer.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.social.showcase.customer.model.CRequirements;
import org.springframework.social.showcase.customer.model.Customer;

import com.mysql.jdbc.Connection;

public class CustomerHelper {

	private DataSource mysqldataSource;
	private Connection connection;
	private JdbcTemplate jdbctemplate;
	private SimpleJdbcInsert jdbcInsertCustomer;
	private SimpleJdbcTemplate simpleJdbcTemplate;
	private SimpleJdbcInsert jdbcInsertCustomerReq;
    
	public CustomerHelper(DataSource mysqldataSource) {
		this.mysqldataSource = mysqldataSource;
		this.jdbctemplate = new JdbcTemplate(mysqldataSource);
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(mysqldataSource);
		this.jdbcInsertCustomer = new SimpleJdbcInsert(mysqldataSource).withTableName("customer").usingGeneratedKeyColumns("C_ID");
		this.jdbcInsertCustomerReq = new SimpleJdbcInsert(mysqldataSource).withTableName("c_requirements").usingGeneratedKeyColumns("CR_ID");		
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
	
	public int addCustomer(Customer c) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("fName", c.getfName());
		parameters.put("lName", c.getlName());
		parameters.put("street", c.getStreet());
		parameters.put("city", c.getCity());
		parameters.put("State", c.getCity());
		parameters.put("zipcode", c.getZipcode());
		parameters.put("marital_status", c.getMartial_status());
		parameters.put("salary_min_val", c.getSalary_min_val());
		parameters.put("salary_max_val", c.getSalary_max_val());
		parameters.put("email_ID", c.getEmail_ID());
		parameters.put("R_ID" , c.getR_ID());
		parameters.put("phone_number", c.getPhone_number());
		parameters.put("customer_priority", c.getCustomer_priority());
		
		try{
		Number newId = jdbcInsertCustomer.executeAndReturnKey(parameters);
		int id =  newId.intValue();
		return id;
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("ERROR :" +  e.getMessage());
			return -1;
		}
		
	}
	
	public int addCustomerReq(CRequirements c) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("number_of_persons", c.getNoOfPersons());
		parameters.put("number_of_bedrooms", c.getNoOfBedrooms());
		parameters.put("city", c.getCity());
		parameters.put("state", c.getState());
		parameters.put("zipcode", c.getZipcode());
		parameters.put("range_amount", c.getRangeAmount());
		parameters.put("type", c.getType());
		
		try{
			Number newId = jdbcInsertCustomerReq.executeAndReturnKey(parameters);
			int id =  newId.intValue();
			return id;
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("ERROR :" +  e.getMessage());
			return -1;
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
	        customer.setSalary_min_val(rs.getString("salary_min_val"));
	        customer.setSalary_max_val(rs.getString("salary_max_val"));
	        customer.setEmail_ID(rs.getString("email_ID"));
	        customer.setPhone_number(rs.getString("phone_number"));
	        customer.setR_ID(rs.getString("R_ID"));
	        customer.setCR_ID(rs.getString("CR_ID"));
	        return customer;
	    }        
	}

	public Boolean updateCustomer(int customerId, int newCustomerReqId) {		
		try{
	    	int i= this.jdbctemplate.update("update customer set CR_ID = ? where c_id = ?", 
	    				newCustomerReqId , customerId);
	    	if(i==1)
	    		return true;
	    	else{
	    		System.out.println("No rows affected!!!!");
	    		return false;
	    	}
		 }catch(DataAccessException de){
		    	de.printStackTrace();
		    	System.out.println("ERROR :" +  de.getMessage());
		    	return false;
		 }
	}
	
	public Boolean editCustomer(Customer customer) {		
		try{
	    	int i= this.jdbctemplate.update("update customer set " +
	    									"fName=?," +
	    									"lName=?," +
	    									"street=?," +
	    									"city=?," +
	    									"state=?," +
	    									"zipcode=?," +
	    									"marital_status=?," +
	    									"salary_min_val=?," +
	    									"salary_max_val=?," +
	    									"email_ID=?," +
	    									"phone_number=?" +
	    									" where c_id = ?", 
	    									customer.getfName(),
	    									customer.getlName(),
	    									customer.getStreet(),
	    									customer.getCity(),
	    									customer.getState(),
	    									customer.getZipcode(),
	    									customer.getMartial_status(),
	    									customer.getSalary_min_val(),
	    									customer.getSalary_max_val(),
	    									customer.getEmail_ID(),
	    									customer.getPhone_number(),
	    									customer.getC_id());
	    	if(i==1)
	    		return true;
	    	else{
	    		System.out.println("No rows affected!!!!");
	    		return false;
	    	}
		 }catch(DataAccessException de){
		    	de.printStackTrace();
		    	System.out.println("ERROR :" +  de.getMessage());
		    	return false;
		 }
	}
}
