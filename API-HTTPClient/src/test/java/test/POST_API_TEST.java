package test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import base.TestBase;
import client.RestClient;
import data.Users;
import util.TestUtil;

public class POST_API_TEST extends TestBase{
	
	TestBase testbase;
	RestClient restclient;
	String baseURL;
	String serviceURL;
	private String URL;
	CloseableHttpResponse httpresponse;
	
	
	@BeforeMethod
	public void setup()
	{
		testbase = new TestBase();
		baseURL = properties.getProperty("URL");
		 serviceURL = properties.getProperty("serviceURL");
		
		 URL = baseURL+serviceURL;
		
		 
	}
	
	//POSITIVE TEST CASE WITH 201 CREATED STATUS
	@Test
	public void POST_CALL_TEST_201() throws JsonGenerationException, JsonMappingException, IOException
	{
		restclient = new RestClient();
		System.out.println("THE URL IS "+ URL);
		
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		headers.put("Authorization", "Bearer 5052639bbac5dcd07e8679d6b432a712d429e017f03e3cfcc38b5e23a3bb38c3");
		
		ObjectMapper mapper = new ObjectMapper();
		Users users = new Users("Umair",TestUtil.getEmail(),"male","active");
		
				
		//Object to JSON string
		String userJsonString = mapper.writeValueAsString(users);
		httpresponse = restclient.post(URL, userJsonString,headers);
		
		int status = httpresponse.getStatusLine().getStatusCode();
		System.out.println("The statis is --> "+status);
		Assert.assertEquals(status, RESPONSE_STATUS_CODE_201);
		
		//Getting entire string from the response
	    String resposneString = EntityUtils.toString(httpresponse.getEntity(),"UTF-8");
	
	    
	    //Converting response into JAVA Object using Un-Marshalling
	    Users usersResObj = mapper.readValue(resposneString, Users.class);
	    System.out.println(usersResObj);
	    
	    //Asserting values of Name, Gender, Email from the response
	    Assert.assertTrue(users.getName().equals(usersResObj.getName()));
	    Assert.assertTrue(users.getGender().equals(usersResObj.getGender()));
	    Assert.assertTrue(users.getEmail().equals(usersResObj.getEmail()));
	    
	}
	
	
	//NEGATIVE TEST CASE WITH AUTHENTICATION FAIL 401 STATUS
	@Test
	public void POST_CALL_TEST_401() throws JsonGenerationException, JsonMappingException, IOException
	{
		restclient = new RestClient();
		System.out.println("THE URL IS "+ URL);

		
		ObjectMapper mapper = new ObjectMapper();
		Users users = new Users("Umair","male","umair@gmail.com","active");
		
				
		//Object to JSON string
		String userJsonString = mapper.writeValueAsString(users);
		httpresponse = restclient.post(URL, userJsonString);
		
		int status = httpresponse.getStatusLine().getStatusCode();
		System.out.println("The statis is --> "+status);
		Assert.assertEquals(status, RESPONSE_STATUS_CODE_401);
	}
	
	
	//NEGATIVE TEST CASE WITH  FAIL 422 STATUS
	@Test
	public void POST_CALL_TEST_422() throws ClientProtocolException, IOException
	{
		restclient = new RestClient();
		System.out.println("THE URL IS "+ URL);
		
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		headers.put("Authorization", "Bearer 5052639bbac5dcd07e8679d6b432a712d429e017f03e3cfcc38b5e23a3bb38c3");

		
		ObjectMapper mapper = new ObjectMapper();
		Users users = new Users("Umair","male","umair@gmail.com","active");
		
		
		//Object to JSON string
		String userJsonString = mapper.writeValueAsString(users);
		httpresponse = restclient.post(URL, userJsonString,headers);
		
		
		//
		int status = httpresponse.getStatusLine().getStatusCode();
		System.out.println("The status code is -->"+status);
		Assert.assertEquals(status, RESPONSE_STATUS_CODE_422);
		
		
		
	}

}
