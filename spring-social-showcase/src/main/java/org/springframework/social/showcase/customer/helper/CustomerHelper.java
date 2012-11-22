package org.springframework.social.showcase.customer.helper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
import org.springframework.social.showcase.customer.model.FBCustomer;

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
	
	
	public List<Customer> findAllCustomers(String R_ID) {
	    try{
	    	return this.jdbctemplate.query( "select * from customer where R_ID="+R_ID, new CustomerMapper());
	    }catch(DataAccessException de){
	    	de.printStackTrace();
	    	System.out.println("ERROR :" +  de.getMessage());
	    	return null;
	    }
		
	}
	
	public List<Customer> findTop5Customers(String R_ID) {
	    try{
	    	return this.jdbctemplate.query( "select * from customer where customer_priority='1' and R_ID="+R_ID+" LIMIT 5", new CustomerMapper());
	    }catch(DataAccessException de){
	    	de.printStackTrace();
	    	System.out.println("ERROR :" +  de.getMessage());
	    	return null;
	    }
		
	}
	
	public int addFBCustomer(FBCustomer c) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("name", c.getName());
		parameters.put("street", c.getStreet());
		parameters.put("city", c.getCity());
		parameters.put("State", c.getState());
		parameters.put("zipcode", c.getZipcode());
		parameters.put("marital_status", c.getMartial_status());
		List<String> rangeList = getSalaryRange(c.getSalary_range());
		parameters.put("salary_min_val", rangeList.get(0));
		parameters.put("salary_max_val", rangeList.get(1));
		parameters.put("email_ID", c.getEmail_ID());
		parameters.put("R_ID" , c.getR_ID());
		parameters.put("phone_number", c.getPhone_number());
		parameters.put("customer_priority", c.getCustomer_priority());
		parameters.put("appointment", c.getAppointment().equalsIgnoreCase("yes"));
		parameters.put("time", c.getTime());
		
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
	
	private List<String> getSalaryRange(String salary_range){
		String rangeLow = "";
		String rangeHigh = "";
		
		int range = Integer.parseInt(salary_range);
		
		switch(range){
		case 1:	rangeLow="0";
				rangeHigh="50000";
			break;
		case 2:	rangeLow="500000";
				rangeHigh="100000";
			break;
		case 3: rangeLow="100000";
				rangeHigh="200000";
			break;
		case 4:	rangeLow="200000";
				rangeHigh="500000";
			break;
		default : 	rangeLow="500000";
					rangeHigh="1000000000000";
				break;
		}


		List<String> rangeList = new ArrayList<String>();
		rangeList.add(rangeLow);
		rangeList.add(rangeHigh);
		return rangeList;
	}
	
	public int addFBCustomerReq(FBCustomer c, int c_id) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		System.out.println("Inside Add FB CSTMR REQ");
		String number_of_bedrooms = "";
		String number_of_baths = "";
		
		if("yes".equalsIgnoreCase(c.getBedRoomNumber3())){
			number_of_bedrooms = "3";
		}
		else if("yes".equalsIgnoreCase(c.getBedRoomNumber2())){
			number_of_bedrooms = "2";
		}
		else if("yes".equalsIgnoreCase(c.getBedRoomNumber1())){
			number_of_bedrooms = "1";
		}
		if("yes".equalsIgnoreCase(c.getBathNumber3())){
			number_of_baths = "3";
		}
		else if("yes".equalsIgnoreCase(c.getBathNumber2())){
			number_of_baths = "2";
		}
		else if("yes".equalsIgnoreCase(c.getBathNumber1())){
			number_of_baths = "1";
		}
		
		parameters.put("number_of_persons", c.getNumberOfPersons());
		parameters.put("house_description", c.getHomeDescription());
		parameters.put("number_of_bedrooms", number_of_bedrooms);
		parameters.put("C_ID", c_id);
		parameters.put("number_of_baths", number_of_baths);
		parameters.put("city", c.getHouse_city());
		System.out.println("state ===" +c.getHouse_state());
		parameters.put("state", c.getHouse_state());
		parameters.put("zipcode", c.getZipcode());
		List<String> rangeList = getRange(c);
		parameters.put("range_low", rangeList.get(0));
		parameters.put("range_high", rangeList.get(1));
		parameters.put("type", getHouseType(c));
		parameters.put("location", getLocation(c));

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
	
	private String getHouseType(FBCustomer c){
		String type = "";
		if("yes".equalsIgnoreCase(c.getType_any())){
			type = "any";
		}
		else if(c.getType_any()==null && "yes".equalsIgnoreCase(c.getType_house()) && c.getType_apartment()==null && c.getType_studio()==null){
			type = "house";
		}
		else if(c.getType_any()==null && "yes".equalsIgnoreCase(c.getType_apartment()) && c.getType_house()==null && c.getType_studio()==null){
			type = "apartment";
		}
		else if(c.getType_any()==null && "yes".equalsIgnoreCase(c.getType_studio()) && c.getType_house()==null && c.getType_apartment()==null){
			type = "studio";
		}
		else if(c.getType_any()==null && "yes".equalsIgnoreCase(c.getType_studio()) && "yes".equalsIgnoreCase(c.getType_house()) && c.getType_apartment()==null){
			type = "studio/house";
		}
		else if(c.getType_any()==null && "yes".equalsIgnoreCase(c.getType_studio()) && "yes".equalsIgnoreCase(c.getType_apartment()) && c.getType_house()==null){
			type = "studio/apartment";
		}
		else if(c.getType_any()==null && "yes".equalsIgnoreCase(c.getType_house()) && "yes".equalsIgnoreCase(c.getType_apartment()) && c.getType_studio()==null){
			type = "house/apartment";
		}
		return type;
	}
	
	private String getLocation(FBCustomer c){
		String type = "";
		if(c.getLocation_downtown()==null && "yes".equalsIgnoreCase(c.getLocation_suburb())){
			type = "suburb";
		}
		else if(c.getLocation_suburb()==null && "yes".equalsIgnoreCase(c.getLocation_downtown())){
			type = "downtown";
		}
		else if("yes".equalsIgnoreCase(c.getLocation_suburb()) && "yes".equalsIgnoreCase(c.getLocation_downtown())){
			type = "any";
		}
		else{
			type="any";
		}
		return type;
	}
	
	private List<String> getRange(FBCustomer c){
		
		String rangeLow = "";
		String rangeHigh = "";
		
		int range = Integer.parseInt(c.getRange());
		
		switch(range){
		case 1:	rangeLow="100";
				rangeHigh="100000";
			break;
		case 2:	rangeLow="100000";
				rangeHigh="400000";
			break;
		case 3: rangeLow="400000";
				rangeHigh="1000000000000";
			break;
		case 4:	rangeLow="100";
				rangeHigh="1000000000000";
			break;
		default : 	rangeLow="100";
					rangeHigh="1000000000000";
				break;
		}


		List<String> rangeList = new ArrayList<String>();
		rangeList.add(rangeLow);
		rangeList.add(rangeHigh);
		return rangeList;
	}
	
	public int addCustomerReq(CRequirements c) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("number_of_persons", c.getNoOfPersons());
		parameters.put("number_of_bedrooms", c.getNoOfBedrooms());
		parameters.put("city", c.getCity());
		parameters.put("state", c.getState());
		parameters.put("zipcode", c.getZipcode());
		//parameters.put("range_amount", c.getRangeAmount());
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
	
	public Customer getCustomer(String id) {
		
		 try{
			 	Customer customer = this.jdbctemplate.query("select * from customer where c_id =\"" +id +"\"", new CustomerMapper()).get(0);
		    	return customer;
		    }catch(DataAccessException de){
		    	de.printStackTrace();
		    	System.out.println("ERROR :" +  de.getMessage());
		    	return null;
		    }
	}

	public List<CRequirements> getCustomerReq(Customer c) {
		
		 try{
		    	return this.jdbctemplate.query("select * from c_requirements where c_id =\"" +c.getC_id()+"\"", new CustomerReqMapper());
		    }catch(DataAccessException de){
		    	de.printStackTrace();
		    	System.out.println("ERROR :" +  de.getMessage());
		    	return null;
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
	
	public List<Customer> findCustomerAppt(String R_ID){
		  try{
		    	return this.jdbctemplate.query( "select * from customer where appointment=1 and R_ID="+R_ID, new CustomerMapper());
		    }catch(DataAccessException de){
		    	de.printStackTrace();
		    	System.out.println("ERROR :" +  de.getMessage());
		    	return null;
		    }
	}
	
	public Boolean editCustomer(Customer customer) {		
		try{
	    	int i= this.jdbctemplate.update("update customer set " +
	    									"name=?," +
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
	    									customer.getName(),
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
	
	private static final class CustomerMapper implements RowMapper<Customer> {

	    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
	        Customer customer = new Customer();
	        customer.setC_id(rs.getString("C_ID"));
	        customer.setName(rs.getString("name"));
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
	        customer.setAppointment(rs.getString("appointment"));
	        customer.setTime(rs.getString("time"));
	        return customer;
	    }        
	}
	
	private static final class CustomerReqMapper implements RowMapper<CRequirements> {

	    public CRequirements mapRow(ResultSet rs, int rowNum) throws SQLException {
	    	CRequirements cRequirements = new CRequirements();
	    	cRequirements.setCr_ID(rs.getString("CR_ID"));
	    	cRequirements.setCity(rs.getString("city"));
	    	cRequirements.setState(rs.getString("state"));
	    	cRequirements.setZipcode(rs.getString("zipcode"));
	    	cRequirements.setType(rs.getString("type"));
	    	cRequirements.setNoOfBedrooms(Integer.parseInt(rs.getString("number_of_bedrooms")));
	    	cRequirements.setNoOfPersons(Integer.parseInt(rs.getString("number_of_persons")));
	    	cRequirements.setNumber_of_baths(rs.getString("number_of_baths"));
	    	cRequirements.setLocation(rs.getString("location"));
	    	cRequirements.setRange_low(rs.getString("range_low"));
	    	cRequirements.setRange_high(rs.getString("range_high"));
	    	cRequirements.setHouse_description(rs.getString("house_description"));
	    	cRequirements.setC_id(rs.getString("C_ID"));
	    	
	    	
	        return cRequirements;
	    }        
	}
}
