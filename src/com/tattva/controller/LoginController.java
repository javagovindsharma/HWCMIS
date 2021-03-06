package com.tattva.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/loginurl")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	     doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("---------------------");
		
		 String userName=req.getParameter("username");
		 String password=req.getParameter("password");
		 
		 System.out.println(userName+"  "+password);
		 
		 HttpSession  session=req.getSession();
		 
		 if(userName.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
			 session.setAttribute("user", "admin");
			 
			 RequestDispatcher rd=req.getRequestDispatcher("/home.jsp");
			 rd.forward(req, resp);
			 
		 }else {
			 RequestDispatcher rd=req.getRequestDispatcher("/login.jsp");
			 rd.forward(req, resp);
		 }
		
		
		
		
		
			
	}
	
	

}
