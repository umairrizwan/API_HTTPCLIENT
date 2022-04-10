package client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class RestClient {
	
	public CloseableHttpResponse getURL(String url) throws ClientProtocolException, IOException
	{
		CloseableHttpClient httpclient = HttpClients.createDefault();//Build the connection with client 
		HttpGet httpget = new HttpGet(url); //This is my http get request
		
		//1. We create CloseableHttpResonpse object by the name of closehttp
		//2. This closehttp object holds API staus response i.e. 200 or 404 or 201
		//3. This closehttp object holds API response and header response as well
		CloseableHttpResponse closehttp =  httpclient.execute(httpget); 
		
		
	return closehttp;
		
	}
	
	//Get method with headers
		public CloseableHttpResponse getURL(String url, HashMap<String, String> headerMap) throws ClientProtocolException, IOException
		{
			CloseableHttpClient httpclient = HttpClients.createDefault();//Build the connection with client
			HttpGet httpget = new HttpGet(url); //This is my http get request
			
			for(Map.Entry<String, String> entry : headerMap.entrySet()) 
			{
				httpget.addHeader(entry.getKey(), entry.getValue());
			}
			
			CloseableHttpResponse closehttp =  httpclient.execute(httpget); 
			
			
		return closehttp;
			
		}
		
		
		//POST Method
		public CloseableHttpResponse post(String url, String entityString, HashMap<String, String> headerMap) throws ClientProtocolException, IOException
		{
			
			CloseableHttpClient httpClient = HttpClients.createDefault(); //Build the connection with client
			HttpPost httpPost = new HttpPost(url); //This is for Post request
			httpPost.setEntity(new StringEntity(entityString)); //This is for JSON payload
			
			for(Map.Entry<String, String> head : headerMap.entrySet())
			{
				httpPost.addHeader(head.getKey(), head.getValue());
				
			}
			
			
			
			CloseableHttpResponse closehttpResponse = httpClient.execute(httpPost);
			return closehttpResponse;
		}
		
		
		//POST Method without header
		public CloseableHttpResponse post(String url, String entityString) throws ClientProtocolException, IOException
		{
			
			CloseableHttpClient httpClient = HttpClients.createDefault(); //Build the connection with client
			HttpPost httpPost = new HttpPost(url); //This is for Post request
			httpPost.setEntity(new StringEntity(entityString)); //This is for JSON payload
			
			
			
			
			CloseableHttpResponse closehttpResponse = httpClient.execute(httpPost);
			return closehttpResponse;
		}

}
