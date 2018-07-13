package com.tattva.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.tattva.dao.connectionProvider;
import com.tattva.restapi.QuestionRestApi;



@WebServlet("/Question")
public class QuestionServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("---------------------");
		
			String method = req.getParameter("method");
			System.out.println(method + "~~~~~~~~~~~~~~~~~~"+method);
			 
			if (method.equalsIgnoreCase("getQuestion")) {
				System.out.println(" getQuestion invoked");
				getQuestionMethod(req, resp);
			}else if (method.equalsIgnoreCase("saveQuestionMethod")) {
				System.out.println(" saveQuestionMethod invoked");
				saveQuestionMethod(req, resp);
			}else if (method.equalsIgnoreCase("setQuestion")) {
					setQuestionMethod(req, resp);
			}else if (method.equalsIgnoreCase("setSection")) {
				
				setSection(req, resp);
			}else if (method.equalsIgnoreCase("setService")) {
				
				setService(req, resp);
			}else if (method.equalsIgnoreCase("setSubService")) {
				
				setSubService(req, resp);
			}else if (method.equalsIgnoreCase("deleteQuestion")) {
				
				deleteQuestion(req, resp);
			}else if (method.equalsIgnoreCase("editQuestion")) {
				
				editQuestion(req, resp);
			}
	     	else {
	     		resp.getWriter().write("Worrng Url");
			System.out.println("worng url");
		 }	

	}

	
	
	public void setSection(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("setSection methid ose");
		
		connectionProvider  obj=new connectionProvider();
		JsonObject str=obj.getSection();
		System.out.println("section data"+str);	
		response.getWriter().write(str.toString());

	}// setSection
	
	public void setService(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("setSection methid ose");
		
		connectionProvider  obj=new connectionProvider();
		JsonObject str=obj.getService();
		System.out.println("services data"+str);	
	 	response.getWriter().write(str.toString());

	}// setSection
	
	
	public void setSubService(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("setSection methid ose");
		
		connectionProvider  obj=new connectionProvider();
		JsonObject str=obj.getSubService();
		
	  	response.getWriter().write(str.toString());

	}// setSection

	
	
	public void getQuestionMethod(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("get Question methid ose");
		
		QuestionRestApi obj=new QuestionRestApi();
		JSONObject str=obj.getQuestionRest();
		
		response.getWriter().write(str.toString());

	}// getQuestionMethod
	
	public void saveQuestionMethod(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("get Question methid ose");
		JsonObject data = new Gson().fromJson(request.getReader(), JsonObject.class);
		
	      //Reading data 
	       String question_text = data.get("quesText").getAsString();
	       String help_text = data.get("help").getAsString();
	       int question_type =Integer.parseInt( data.get("question").getAsString());
	       String subservice_id =data.get("subservice").getAsString();
	       String service_id =data.get("service").getAsString();
	       int section_id =Integer.parseInt(data.get("section").getAsString());
	     
	       String validation = data.get("validation").getAsString();
	       String options = data.get("option").getAsString();
	
	       System.out.println("question_text"+question_text+"\nhelp_text"+help_text+"\nquestion_type"+question_type+"\nsubservice_id"+subservice_id);
	       System.out.println("service_id"+service_id+"\nsection_id"+section_id+"\nvalidation"+validation+"\noptions"+options);
	       
	       connectionProvider  obj=new connectionProvider();
		  JsonObject str=obj.saveQuestion(question_text, service_id,subservice_id,question_type,validation,options,help_text,section_id);
		
		   response.getWriter().write(str.toString());

	}// saveQuestionMethod
	
	public void setQuestionMethod(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("set Question methid ose");
		
		connectionProvider  obj=new connectionProvider();
		JsonObject str=obj.SetQuestion();
		
	  	response.getWriter().write(str.toString());

	}// saveQuestionMethod
	
	

	
	
	public void deleteQuestion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		 JsonObject data = new Gson().fromJson(request.getReader(), JsonObject.class);
		  //Reading data 
	       int question_id = Integer.parseInt(data.get("question_id").getAsString());
		connectionProvider  obj=new connectionProvider();
		JsonObject str=obj.deleteQuestion(question_id);
		System.out.println(" deleteQuestion methid ose"+question_id);	
		response.getWriter().write(str.toString());

		

	}// deleteQuestion
	   
	
	public void editQuestion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		   
	       JsonObject data = new Gson().fromJson(request.getReader(), JsonObject.class);
			
		      //Reading data 
	           int question_id = Integer.parseInt(data.get("question_id").getAsString());
		       String question_text = data.get("quesText").getAsString();
		       String help_text = data.get("help").getAsString();
		       int question_type =Integer.parseInt( data.get("question").getAsString());
		       String subservice_id = data.get("subservice").getAsString();
		       String service_id = data.get("service").getAsString();
		       int section_id =Integer.parseInt(data.get("section").getAsString());
		       String validation = data.get("validation").getAsString();
		       String options = data.get("option").getAsString();
		connectionProvider  obj=new connectionProvider();
		JsonObject str=obj.editQuestion(question_id,question_text, service_id,subservice_id,question_type,validation,options,help_text,section_id);
		System.out.println(" deleteQuestion methid ose"+question_id);	
		response.getWriter().write(str.toString());

		

	}// editQuestion
	   
	
}
