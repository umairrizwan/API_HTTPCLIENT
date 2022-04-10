package test;

import java.io.IOException;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import client.RestClient;
import util.TestUtil;

public class GET_API_TEST extends TestBase{
	
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
	
	
	//POSITIVE TEST CASE WITH 200  STATUS
	@Test(priority = 1)
	public void GET_CALL_TEST_200() throws ClientProtocolException, IOException
	
	{
		restclient = new RestClient();
		httpresponse = restclient.getURL(URL);
		
		//Verfiying Status code
		int response = httpresponse.getStatusLine().getStatusCode();
		System.out.println("The Response is -->" + response);
		Assert.assertEquals(response, RESPONSE_STATUS_CODE_200);
		
		//JSON Reponse body
		String respString = EntityUtils.toString(httpresponse.getEntity(), "UTF-8"); //This will return the entire response string of API
		//This will return the response in string which we will convert it into JSON below
		JSONArray Responsejson = new JSONArray(respString);
		System.out.println("The response is---> "+Responsejson);		
		
		
	}
	
	//NEGATIVE TEST CASE WITH 404  STATUS
	@Test(priority = 2)
	public void GET_CALL_TEST_404() throws ClientProtocolException, IOException
	
	{
		restclient = new RestClient();
		String user404 = "445435";
		URL = URL + user404;
		System.out.println("THE URL IS --> "+URL);
		httpresponse = restclient.getURL(URL);
		
		//Verfiying Status code
		int response = httpresponse.getStatusLine().getStatusCode();
		System.out.println("The Response is -->" + response);
		Assert.assertEquals(response, RESPONSE_STATUS_CODE_404);
		
		
		
	}
	

	

}
