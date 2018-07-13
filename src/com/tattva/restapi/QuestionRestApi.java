package com.tattva.restapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class QuestionRestApi {
	
	public static final String urlid= "http://103.231.40.154:8080"; //"http://localhost:8080";
	
	private static final String targetURL = urlid+"/HWCService/HWC?method=GetQuestion";
	private static final String saveURL = urlid+"/HWCService/HWC?method=getServicesId";
	private static final String setQuestionURL=urlid+"/HWCService/HWC?method=setQuestion";
	
	public JSONObject getQuestionRest() throws JSONException, IOException {
		
		JSONObject jsonArray=null;
		URL targetUrl = new URL(targetURL);
		HttpURLConnection httpConnection = (HttpURLConnection) targetUrl.openConnection();
		httpConnection.setDoOutput(true);
		httpConnection.setRequestMethod("POST");
		httpConnection.setRequestProperty("Content-Type", "application/json");
		OutputStream outputStream = httpConnection.getOutputStream();
		outputStream.flush();
		if (httpConnection.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
				+ httpConnection.getResponseCode());
		}

		BufferedReader responseBuffer = new BufferedReader(new InputStreamReader(
				(httpConnection.getInputStream())));
		System.out.println("Output from Server:\n");
   
		String output,str="";
		while ((output = responseBuffer.readLine()) != null) {
			System.out.println(output);
			str=str+output;
		}
		   
		jsonArray=new JSONObject(new JSONTokener(str));
		System.out.println("getQuestion  Data "+jsonArray);
		
		 
      	httpConnection.disconnect();
		  return jsonArray;

		}	 
	
	
	
	
       public JSONObject saveQuestionRest() throws JSONException, IOException {
		
			JSONObject jsonArray=null;
			URL targetUrl = new URL(saveURL);
			HttpURLConnection httpConnection = (HttpURLConnection) targetUrl.openConnection();
			httpConnection.setDoOutput(true);
			httpConnection.setRequestMethod("POST");
			httpConnection.setRequestProperty("Content-Type", "application/json");
			OutputStream outputStream = httpConnection.getOutputStream();
			outputStream.flush();
			if (httpConnection.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
					+ httpConnection.getResponseCode());
			}
	
			BufferedReader responseBuffer = new BufferedReader(new InputStreamReader(
					(httpConnection.getInputStream())));
			System.out.println("Output from Server:\n");
	   
			String output,str="";
			while ((output = responseBuffer.readLine()) != null) {
				System.out.println(output);
				str=str+output;
			}
			   
			jsonArray=new JSONObject(new JSONTokener(str));
			System.out.println("Approve  Data "+jsonArray);
			
			 
	      	httpConnection.disconnect();
			  return jsonArray;

		}	 
	
       
       
       
       public JSONObject editQuestionRest() throws JSONException, IOException {
   		
	   		JSONObject jsonArray=null;
	   		URL targetUrl = new URL(targetURL);
	   		HttpURLConnection httpConnection = (HttpURLConnection) targetUrl.openConnection();
	   		httpConnection.setDoOutput(true);
	   		httpConnection.setRequestMethod("POST");
	   		httpConnection.setRequestProperty("Content-Type", "application/json");
	   		OutputStream outputStream = httpConnection.getOutputStream();
	   		outputStream.flush();
	   		if (httpConnection.getResponseCode() != 200) {
	   			throw new RuntimeException("Failed : HTTP error code : "
	   				+ httpConnection.getResponseCode());
	   		}
	
	   		BufferedReader responseBuffer = new BufferedReader(new InputStreamReader(
	   				(httpConnection.getInputStream())));
	   		System.out.println("Output from Server:\n");
	      
	   		String output,str="";
	   		while ((output = responseBuffer.readLine()) != null) {
	   			System.out.println(output);
	   			str=str+output;
	   		}
	   		   
	   		jsonArray=new JSONObject(new JSONTokener(str));
	   		System.out.println("Approve  Data "+jsonArray);
	   		
	   		 
	         	httpConnection.disconnect();
	   		  return jsonArray;

   		}	 
       
       
       public JSONObject setQuestionRest() throws JSONException, IOException {
      		
	   		JSONObject jsonArray=null;
	   		URL targetUrl = new URL(setQuestionURL);
	   		HttpURLConnection httpConnection = (HttpURLConnection) targetUrl.openConnection();
	   		httpConnection.setDoOutput(true);
	   		httpConnection.setRequestMethod("POST");
	   		httpConnection.setRequestProperty("Content-Type", "application/json");
	   		OutputStream outputStream = httpConnection.getOutputStream();
	   		outputStream.flush();
	   		if (httpConnection.getResponseCode() != 200) {
	   			throw new RuntimeException("Failed : HTTP error code : "
	   				+ httpConnection.getResponseCode());
	   		}
	
	   		BufferedReader responseBuffer = new BufferedReader(new InputStreamReader(
	   				(httpConnection.getInputStream())));
	   		System.out.println("Output from Server:\n");
	      
	   		String output,str="";
	   		while ((output = responseBuffer.readLine()) != null) {
	   			System.out.println(output);
	   			str=str+output;
	   		}
	   		   
	   		jsonArray=new JSONObject(new JSONTokener(str));
	   		System.out.println("Approve  Data "+jsonArray);
	   		
	   		 
	         	httpConnection.disconnect();
	   		  return jsonArray;

  		}	 
       
       
	
	
}