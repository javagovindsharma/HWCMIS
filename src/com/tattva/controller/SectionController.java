package com.tattva.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

public class SectionController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		  
		 String method=req.getParameter("method");
		 
		 if(method.equalsIgnoreCase("getSection")) {
			 getSection(req,resp);
		 }else if(method.equalsIgnoreCase("saveSection")) {
			 saveSecion(req,resp);
		 }else if(method.equalsIgnoreCase("editSection")) {
			 editSection(req,resp);
		 }else if(method.equalsIgnoreCase("deActivateSection")) {
			 deActivateSection(req,resp);
		 }else {
			 resp.getWriter().write("Worrng URl");
		 }
		       
		
		
	}// doPost() close

	
	 public JsonObject getSection(HttpServletRequest req, HttpServletResponse resp) {
		
		 return new JsonObject();
	 }//getSection
	
	 
	 public JsonObject saveSecion(HttpServletRequest req, HttpServletResponse resp) {
			
		 return new JsonObject();
	 }//getSection
	 
	 
	 public JsonObject editSection(HttpServletRequest req, HttpServletResponse resp) {
			
		 return new JsonObject();
	 }//getSection
	 
	 
	 public JsonObject deActivateSection(HttpServletRequest req, HttpServletResponse resp) {
			
		 return new JsonObject();
	 }//getSection
	
}
