package com.tattva.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.tattva.dao.ReferalDao;


@WebServlet("/referal")
public class ReferalController extends HttpServlet {
	
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
			 
			if (method.equalsIgnoreCase("getSubcenter")) {
				System.out.println(" getSubcenter invoked");
				getSubcenter(req, resp);
			}else if (method.equalsIgnoreCase("getDistrict")) {
				System.out.println(" getDistrict invoked");
				getDistrict(req, resp);
			}else if (method.equalsIgnoreCase("getBlock")) {
				System.out.println(" getVillage invoked");
				getBlock(req, resp);
			}else if (method.equalsIgnoreCase("getVillage")) {
				System.out.println(" getVillage invoked");
				getVillage(req, resp);
			}else if (method.equalsIgnoreCase("getAsha")) {
				getAsha(req,resp);
			}else if (method.equalsIgnoreCase("getReferalData")) {
				getReferalData(req,resp);
			}else if (method.equalsIgnoreCase("getReferalSearchData")) {
				getReferalSearchData(req,resp);
			}else {
	     		resp.getWriter().write("Worrng Url");
			System.out.println("worng url");
		 }	
			
	}

	
	
	public void getSubcenter(HttpServletRequest request, HttpServletResponse response)	throws IOException, ServletException {
		System.out.println("getSubcenter methid ose");
		
		 JsonObject data = new Gson().fromJson(request.getReader(), JsonObject.class);
		 int  id_block = Integer.parseInt(data.get("id_block").getAsString());
	     JsonObject str=new ReferalDao().getSubCenter(id_block);
		
		 response.getWriter().write(str.toString());

	}// getSubcenter
	
	
	public void getDistrict(HttpServletRequest request, HttpServletResponse response)	throws IOException, ServletException {
		System.out.println("getSubcenter methid ose");
		
	     JsonObject str=new ReferalDao().getDistrict();
		
		 response.getWriter().write(str.toString());

	}// getSubcenter
	
	public void getBlock(HttpServletRequest request, HttpServletResponse response)	throws IOException, ServletException {
		System.out.println("getSubcenter methid ose");
		
		 JsonObject data = new Gson().fromJson(request.getReader(), JsonObject.class);
		 int  id_district = Integer.parseInt(data.get("id_district").getAsString());
	     JsonObject str=new ReferalDao().getBlock(id_district);
		
		 response.getWriter().write(str.toString());

	}// getSubcenter
	
	
	
	public void getVillage(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		 System.out.println("getVillage methid ose");
		 JsonObject data = new Gson().fromJson(request.getReader(), JsonObject.class);
		 String subcenter_id = data.get("subcenter").getAsString();
	     JsonObject str=new ReferalDao().getVillage(subcenter_id);
		
	     System.out.println("village----->>>"+str);
	     response.getWriter().write(str.toString());

	}// getVillage
	
	public void getAsha(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		 System.out.println("getAsha methid ose");
		 JsonObject data = new Gson().fromJson(request.getReader(), JsonObject.class);
		 String village_id = data.get("village").getAsString();
	     JsonObject str=new ReferalDao().getAsha(village_id);
	     
	     System.out.println("asha----->>>"+str);
		 response.getWriter().write(str.toString());

	}// getVillage
	
	
	
	
	public void getReferalSearchData(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		 System.out.println("getReferalData methid ose");
		
		 JsonObject data = new Gson().fromJson(request.getReader(), JsonObject.class);
		 int subcenter_id = Integer.parseInt(data.get("id_subcenter").getAsString());
		 int village_id = Integer.parseInt(data.get("id_village").getAsString());
		 int asha_id = Integer.parseInt(data.get("id_asha").getAsString());
		 int service_id =Integer.parseInt( data.get("servicesCell").getAsString());
		 int subService_id =Integer.parseInt( data.get("subServices").getAsString());
		 String from_date = data.get("id_form_date").getAsString();
		 String to_date = data.get("id_to_date").getAsString();
		 
		 
		 JsonObject str=new ReferalDao().getReferedDataDao(subcenter_id, village_id, asha_id, service_id, subService_id, from_date, to_date);
		
	     System.out.println("getReferalData----->>>"+str);
	     response.getWriter().write(str.toString());

	}// getVillage
	
	
	
	public void getReferalData(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		 System.out.println("getReferalData methid ose");
		
		 
		 JsonObject str=new ReferalDao().getReferedDataDao(0,0,0,0,0,"","");
		
	     System.out.println("getReferalData----->>>"+str);
	     response.getWriter().write(str.toString());

	}// getVillage
	
	
	
}
