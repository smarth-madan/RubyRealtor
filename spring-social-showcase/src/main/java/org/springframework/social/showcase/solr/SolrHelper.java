package org.springframework.social.showcase.solr;

import java.net.MalformedURLException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CommonsHttpSolrServer;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.social.showcase.customer.model.CRequirements;
import org.springframework.social.showcase.mlsListing.model.Property;

public class SolrHelper {

	private String url = "localhost:8983/solr";
	private SolrServer server;
	private DataSource mysqldataSource;
	private JdbcTemplate jdbctemplate;
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	public SolrHelper(DataSource mysqldataSource) {
		this.mysqldataSource = mysqldataSource;
		this.jdbctemplate = new JdbcTemplate(mysqldataSource);
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(mysqldataSource);
	}
	
	
	public List<Property> searchListing(CRequirements creq){
		
		return null;
	}
	private void getServer(){
		try {
			  server = new CommonsHttpSolrServer(url);
			  ((CommonsHttpSolrServer) server).setSoTimeout(1000);  // socket read timeout
			  ((CommonsHttpSolrServer) server).setConnectionTimeout(100);
			  ((CommonsHttpSolrServer) server).setDefaultMaxConnectionsPerHost(100);
			  ((CommonsHttpSolrServer) server).setMaxTotalConnections(100);
			  ((CommonsHttpSolrServer) server).setFollowRedirects(false);  // defaults to false
			  // allowCompression defaults to false.
			  // Server side must support gzip or deflate for this to have any effect.
			  ((CommonsHttpSolrServer) server).setAllowCompression(true);
			  ((CommonsHttpSolrServer) server).setMaxRetries(1); // defaults to 0.  > 1 not recommended.
			  ((CommonsHttpSolrServer) server).setParser(new XMLResponseParser()); // binary parser is used by default
			  
			  
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Could not get the Solr Server!!!!");
		}
	}
	
	public List<Property> search(String description){
		String[] words = description.split("[ .,\"]+");
		for(int i=0;i<words.length;i++){
			words[i]=words[i].toLowerCase();
		}
		
		List<String> wordList = Arrays.asList(words);
		List<String> tags = getTags();
		
		tags.retainAll(wordList);
		
		String solrQuery = "tags:(";
		for(String tag : tags){
			solrQuery = solrQuery + "*" + tag+ "*" +" OR ";
		}
		solrQuery = solrQuery.substring(0, solrQuery.length()-4);
		solrQuery = solrQuery + ")";
		
		SolrQuery query = new SolrQuery();
		query.setQuery( solrQuery );
		// query.addSortField( "price", SolrQuery.ORDER.asc );
		
		getServer();
		
		
		 try {
			QueryResponse rsp = server.query( query );
			SolrDocumentList docs = rsp.getResults();
			
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return null;
	}

	
	public List<String> getTags() {
		List<String> tagList = null;
	    try{
	    		tagList = this.jdbctemplate.query( "select name from tags", new TagMapper());
	    }catch(DataAccessException de){
	    	de.printStackTrace();
	    	System.out.println("ERROR :" +  de.getMessage());
	    	return null;
	    }	
    	return tagList;
	}
	
	private static final class TagMapper implements RowMapper<String> {

	    public String mapRow(ResultSet rs, int rowNum) throws SQLException {
	        return rs.getString("name").toLowerCase();
	    }        
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DriverManagerDataSource factory = new DriverManagerDataSource("com.mysql.jdbc.Driver",
				"jdbc:mysql://localhost/realtor_social",
				"realtor",
				"realtor");
		
		SolrHelper s= new SolrHelper(factory);
		s.search("This is a safe. What, do air you \"mean\".");

	}
}
