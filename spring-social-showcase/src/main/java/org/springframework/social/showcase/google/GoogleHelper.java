package org.springframework.social.showcase.google;

import java.io.IOException;
import java.util.List;

import net.sf.json.JSONObject;

public class GoogleHelper{
	
	public void testAddress() throws IOException
	{
		String address = "San Jose CA";
		GeoCoder gc = new GeoCoder();
		JSONObject json = gc.getGoogleObject(address);
		System.out.println(json.toString());
		List<String> zipCodes = GeoCoder.getZipCodes(json);

		System.out.println();
		for(int i=0;i<zipCodes.size();i++)
			System.out.print(" " + zipCodes.get(i));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GoogleHelper s= new GoogleHelper();
		try {
			s.testAddress();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public int calcDistance(double latA, double longA, double latB, double longB)
	{
	  double theDistance = (Math.sin(Math.toRadians(latA)) *
	                        Math.sin(Math.toRadians(latB)) +
	                        Math.cos(Math.toRadians(latA)) *
	                        Math.cos(Math.toRadians(latB)) *
	                        Math.cos(Math.toRadians(longA - longB)));

	  return (int) ((Math.toDegrees(Math.acos(theDistance))) * 69.09);
	}
	
	

}
