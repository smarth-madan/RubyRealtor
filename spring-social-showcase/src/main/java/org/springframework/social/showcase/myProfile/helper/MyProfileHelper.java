package org.springframework.social.showcase.myProfile.helper;

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
import org.springframework.social.showcase.customer.model.CRequirements;
import org.springframework.social.showcase.customer.model.Customer;
import org.springframework.social.showcase.myProfile.model.GmailAccount;
import org.springframework.social.showcase.myProfile.model.MyProfile;

import com.mysql.jdbc.Connection;

public class MyProfileHelper {
	


	private DataSource mysqldataSource;
	private Connection connection;
	private JdbcTemplate jdbctemplate;
	private SimpleJdbcInsert jdbcInsertCustomer;
	private SimpleJdbcTemplate simpleJdbcTemplate;
	private SimpleJdbcInsert jdbcInsertCustomerReq;
    
	public MyProfileHelper(DataSource mysqldataSource) {
		this.mysqldataSource = mysqldataSource;
		this.jdbctemplate = new JdbcTemplate(mysqldataSource);
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(mysqldataSource);
		this.jdbcInsertCustomer = new SimpleJdbcInsert(mysqldataSource).withTableName("customer").usingGeneratedKeyColumns("C_ID");
		this.jdbcInsertCustomerReq = new SimpleJdbcInsert(mysqldataSource).withTableName("c_requirements").usingGeneratedKeyColumns("CR_ID");		
	}
	
	
	
	
	public List<MyProfile> getRealtorDetails(String emailId) {
	    try{	
	    		System.out.println("Inside Realtor details");
	    	 	//return this.jdbctemplate.query("select * from Realtor where emailId = "+emailId, new RealtorMapper());
	    	 	return this.jdbctemplate.query("select * from Realtor where R_ID = 1", new RealtorMapper());
	    	 	
	    }catch(DataAccessException de){
	    	de.printStackTrace();
	    	System.out.println("ERROR :" +  de.getMessage());
	    	return null;
	    }
		
	}
	
	
	
	
	
	private static final class RealtorMapper implements RowMapper<MyProfile> {

	    public MyProfile mapRow(ResultSet rs, int rowNum) throws SQLException {
	        MyProfile myProfile = new MyProfile();
	        myProfile.setFname(rs.getString("fName"));
	        myProfile.setLname(rs.getString("lName"));
	        myProfile.setStreet(rs.getString("street"));
	        myProfile.setCity(rs.getString("city"));
	        myProfile.setState(rs.getString("state"));
	        myProfile.setZipcode(rs.getString("zipcode"));
	        myProfile.setEmailId(rs.getString("email_Id"));
	        myProfile.setRealtorId(rs.getString("R_ID"));
	        myProfile.setPhoneNumber(rs.getString("phone_Number"));	    
	        myProfile.setGmailId(rs.getString("gmail_ID"));
	        myProfile.setPassword(rs.getString("gmailPassword"));	
	        
	        return myProfile;
	    }        
	}

	public Boolean updateMyProfile(MyProfile myProfile) {
		
		try{
	    	int i= this.jdbctemplate.update("update realtor set fName = ? , lName = ?, street = ? , city = ?, state = ? , zipCode = ?,  email_Id = ?, phone_Number = ? where R_ID = ?", 
	    			myProfile.getFname() , myProfile.getLname(), myProfile.getStreet() ,myProfile.getCity() ,myProfile.getState(), myProfile.getZipcode(), myProfile.getEmailId(), myProfile.getphoneNumber(),1);
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
	
	public Boolean updateGmailAccount(GmailAccount gmailAccount) {
		
		try{
	    	int i= this.jdbctemplate.update("update realtor set gmail_Id = ?, gmailPassword = ? where R_ID = ?", gmailAccount.getEmailId(),gmailAccount.getPassword(),1);
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
