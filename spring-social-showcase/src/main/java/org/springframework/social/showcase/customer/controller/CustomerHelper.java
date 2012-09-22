package org.springframework.social.showcase.customer.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DataSourceUtils;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import org.springframework.social.showcase.customer.model.*;

public class CustomerHelper {

	private DataSource mysqldataSource;
	private Connection connection;
	private JdbcTemplate jdbctemplate;
	
	public CustomerHelper(DataSource mysqldataSource) {
		this.mysqldataSource = mysqldataSource;
		this.jdbctemplate = new JdbcTemplate(mysqldataSource);
	}
	

	
	public List<Customer> getCustomers(){
		try {
			connection = (Connection) DataSourceUtils.getConnection(mysqldataSource);
		    // retrieve a list of three random cities
		    PreparedStatement ps = (PreparedStatement) connection.prepareStatement("select * from Customer");
		    ResultSet rs = ps.executeQuery();
		    while(rs.next()) {
		        String city = rs.getString("City");
		        String country = rs.getString("Country");
		        System.out.printf("The city %s is in %s%n", city, country);
		    }
		} catch (SQLException ex) {
		    // something has failed and we print a stack trace to analyse the error
		    ex.printStackTrace();
		    // ignore failure closing connection
		    try { connection.close(); } catch (SQLException e) { }
		} finally {
		    // properly release our connection
		    DataSourceUtils.releaseConnection(connection, mysqldataSource);
		}
		
		return null;
	}
	
	public List<Customer> findAllCustomers() {
	    return this.jdbctemplate.query( "select * from Customer", new CustomerMapper());
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
