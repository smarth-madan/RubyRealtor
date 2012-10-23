package org.springframework.social.showcase.mlsListing.helper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.social.showcase.mlsListing.model.Property;
import org.springframework.social.showcase.myProfile.model.MyProfile;

import com.mysql.jdbc.Connection;

public class MlsListingHelper {

	private static String BASE_URL = "resources/images/";
	private DataSource mysqldataSource;
	private Connection connection;
	private JdbcTemplate jdbctemplate;
	private SimpleJdbcInsert jdbcGetProperty;
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
    
	public MlsListingHelper(DataSource mysqldataSource) {
		this.mysqldataSource = mysqldataSource;
		this.jdbctemplate = new JdbcTemplate(mysqldataSource);
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(mysqldataSource);
		this.jdbcGetProperty = new SimpleJdbcInsert(mysqldataSource).withTableName("mls_listings").usingGeneratedKeyColumns("MLS_ID");
				
	}
	
	
	
	
	public List<Property> getPropertyDetails() {
	    try{	
	    		System.out.println("Inside Realtor details");
	    	 	//return this.jdbctemplate.query("select * from Realtor where emailId = "+emailId, new RealtorMapper());
	    	 	return this.jdbctemplate.query("select * from mls_listings", new PropertyMapper());
	    	 	
	    }catch(DataAccessException de){
	    	de.printStackTrace();
	    	System.out.println("ERROR :" +  de.getMessage());
	    	return null;
	    }
		
	}
	
	public List<Property> getIndividualPropertyDetails(String mlsId) {
	    try{	
	    		System.out.println("Inside Realtor details");
	    	 	return this.jdbctemplate.query("select * from mls_listings where MLS_ID = "+mlsId, new PropertyMapper());
	    	 	//return this.jdbctemplate.query("select * from mls_listings", new PropertyMapper());
	    	 	
	    }catch(DataAccessException de){
	    	de.printStackTrace();
	    	System.out.println("ERROR :" +  de.getMessage());
	    	return null;
	    }
		
	}
	
	private static final class PropertyMapper implements RowMapper<Property> {

	    public Property mapRow(ResultSet rs, int rowNum) throws SQLException {
	    	Property property = new Property();
	    	property.setImage(BASE_URL+"/"+rs.getString("image"));
	        property.setStreet(rs.getString("street"));
	        property.setCity(rs.getString("city"));
	        property.setState(rs.getString("state"));
	        property.setZipcode(rs.getString("zipcode"));
	        property.setBed_bath(rs.getString("bed_bath"));
	        property.setSize(rs.getString("size"));
	        property.setMLS_ID(rs.getString("MLS_ID"));
	        property.setType(rs.getString("type"));
	        property.setPrice(rs.getString("price"));
	        property.setParking(rs.getString("parking"));
	        property.setGarage(rs.getString("garage"));
	        
	        return property;
	    }        
	}


}
