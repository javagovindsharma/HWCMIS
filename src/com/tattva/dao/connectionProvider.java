package com.tattva.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;


public class connectionProvider {

	public static final String SAVE_QUESTION_QUERY="INSERT INTO question_master(question_text, service_id,subservice_id,question_type,validation,options,help_text,section_id) "+
	                                                                            " values(?,?,?,?,?,?,?,?)";
	
	
	public static final String EDIT_QUESTION_QUERY="UPDATE  question_master  SET question_text=?,"
			+ " service_id=?,subservice_id=?,question_type=?,validation=?,options=?,help_text=?,"
			+ " section_id=?   WHERE question_id=?";
            
 

	
	public static final String DELETE_QUESTION_QUERY="UPDATE  question_master  SET status=1  WHERE question_id = ?";
	 
	
	public Connection getInstanceConnection(){
		Connection con=null;
		try {
		
		   Class.forName("com.mysql.jdbc.Driver");  
		    con=DriverManager.getConnection("jdbc:mysql://180.179.206.173:3306/hwc","root","Root@123");
		}catch(Exception e) {
			e.printStackTrace();
		}
		   
		   return con;
	  }
	   
	   
	
	public Connection getInstanceConnectionNHM(){
		Connection con=null;
			try {
			
			   Class.forName("com.mysql.jdbc.Driver");  
			    con=DriverManager.getConnection("jdbc:mysql://180.179.206.173:3306/spreadcr_testbcpm","root","Root@123");
			}catch(Exception e) {
				e.printStackTrace();
			 }
		   
		   return con;
	  }
	
	
	   public JsonObject getSection(){
		   JsonObject json_response=new JsonObject();
	   	     JsonArray data_json=new JsonArray();
		   System.out.println("my Section data");
		
			 Connection con=null;Statement st=null;ResultSet rs=null;
				   try {
					con=getInstanceConnection();
					st=con.createStatement();
					rs=st.executeQuery("SELECT section_id,section_name  from section_master  order by section_name");
					while(rs.next()) {
						 JsonObject json=new JsonObject();
			             json.addProperty("SourceName", String.valueOf(rs.getInt(1)));
			             json.addProperty("SourceValue", rs.getString(2).toString());
			             data_json.add(json);
					}  
					 json_response.add("fill", data_json);  
					}catch (SQLException  e) {
						 e.printStackTrace();
						 JsonObject json=new JsonObject();
			             json.addProperty("SourceName", "0");
			             json.addProperty("SourceValue","Technical Error");
			             data_json.add(json);
						 json_response.add("fill", data_json);  
					}finally {
   						try {
   							rs.close();
   							st.close();
   							rs.close();
   						}catch(Exception e) {
   							e.printStackTrace();
   						}
   					}
				   		   
				   return json_response;
			    }
			   
	 		   
		   public JsonObject getService(){
	  	        JsonObject json_response=new JsonObject();
		   	    JsonArray data_json=new JsonArray();
			   System.out.println("my Section data");
					
			    Connection con=null;Statement st=null;ResultSet rs=null;
				   try {
					con=getInstanceConnection();
					st=con.createStatement();
					rs=st.executeQuery("SELECT id,service_name  from services_master  order by  service_name");
					while(rs.next()) {
						 JsonObject json=new JsonObject();
			             json.addProperty("SourceName", String.valueOf(rs.getInt(1)));
			             json.addProperty("SourceValue", rs.getString(2).toString());
			             data_json.add(json);
					}  
					 json_response.add("fill", data_json);  
					} catch (SQLException  e) {
						 e.printStackTrace();
						 JsonObject json=new JsonObject();
			             json.addProperty("SourceName", "0");
			             json.addProperty("SourceValue","Technical Error");
			             data_json.add(json);
						 json_response.add("fill", data_json);  
					}finally {
   						try {
   							rs.close();
   							st.close();
   							rs.close();
   						}catch(Exception e) {
   							e.printStackTrace();
   						}
   					}
									   
				   return json_response;
				 }
		   
	        	
	    	public JsonObject getSubService(){
			        JsonObject json_response=new JsonObject();
			   	    JsonArray data_json=new JsonArray();
				   System.out.println("my Section data");
						
				    Connection con=null;Statement st=null;ResultSet rs=null;
					   try {
						con=getInstanceConnection();
						st=con.createStatement();
						rs=st.executeQuery("SELECT id, subservices_name  from subservices_master  order by  subservices_name");
						while(rs.next()) {
							 JsonObject json=new JsonObject();
				             json.addProperty("SourceName", String.valueOf(rs.getInt(1)));
				             json.addProperty("SourceValue", rs.getString(2).toString());
				             data_json.add(json);
						}  
						 json_response.add("fill", data_json);  
						} catch (SQLException  e) {
							 e.printStackTrace();
							 JsonObject json=new JsonObject();
				             json.addProperty("SourceName", "0");
				             json.addProperty("SourceValue","Technical Error");
				             data_json.add(json);
							 json_response.add("fill", data_json);  
						}finally {
	   						try {
	   							rs.close();
	   							st.close();
	   							rs.close();
	   						}catch(Exception e) {
	   							e.printStackTrace();
	   						}
	   					}
					   				   
					   return json_response;
	   			  }
	   
	   
	    	
	    	
	    	public JsonObject SetQuestion(){
		        JsonObject json_response=new JsonObject();
		   	    JsonArray data_json=new JsonArray();
			   System.out.println("my Section data");
					int num=6;
			try {		
			      for(int i=1;i<=num;i++) {  	
			     		 JsonObject json=new JsonObject();
			             json.addProperty("SourceName", i);
			             
			             switch(i) {
			              
			             case 1:  json.addProperty("SourceValue","Numeric" );
			                       break;
			             case 2:  json.addProperty("SourceValue","Text" );          
			                         break;
			             case 3:  json.addProperty("SourceValue","Multiple Select box " );
	                       			break;
			             case 4:  json.addProperty("SourceValue","Drop Down" );
	                       			break;
			             case 5:  json.addProperty("SourceValue","Radio" );
	                       				break;
			             case 6:  json.addProperty("SourceValue","Date" );
	                       		
			             }
			                
			                data_json.add(json);
			      }  
					 json_response.add("fill", data_json);  
					
						
			}catch(Exception e) {
			        JsonObject json=new JsonObject();
			             json.addProperty("SourceName", "0");
			             json.addProperty("SourceValue","Technical Error");
			             data_json.add(json);
						 json_response.add("fill", data_json);  
					
   					}
				   				   
				   return json_response;
   			  }
	    	
	    	
	    	public JsonObject saveQuestion(String question_text, String service_id,String subservice_id,int  question_type,String validation,String options,String help_text,int section_id) {
	    		
	    		JsonObject json_response=new JsonObject();
		   	   
		   	   Connection con=null;PreparedStatement ps=null;int rs=0;
			   try {
				con=getInstanceConnection();
				ps=con.prepareStatement(SAVE_QUESTION_QUERY);
				ps.setString(1,question_text);
				ps.setString(2, service_id);
				ps.setString(3, subservice_id);
				ps.setInt(4, question_type);
				ps.setString(5, validation);
				ps.setString(6,options);
				ps.setString(7, help_text);
				ps.setInt(8, section_id);
				rs=ps.executeUpdate();
				if(rs!=0) {
					json_response.addProperty("DATA","Question Saved");
				}else {
					json_response.addProperty("DATA","Question Not  Saved");
				}
				
				ps.close();
				con.close();
				 
				} catch (SQLException e) {
					 e.printStackTrace();
					 json_response.addProperty("DATA","Technical Error Occured");
				} finally {
						try {
							
							ps.close();
							con.close();
						}catch(Exception e) {
							e.printStackTrace();
						}
					}
		   	    
		   	    
		   	    return json_response;
	    	}//saveQuestion close
	    	
	    	
	    	
      public JsonObject editQuestion(int question_id,String question_text, String service_id,String subservice_id,int  question_type,String validation,String options,String help_text,int section_id) {
	   
    	      JsonObject json_response=new JsonObject();
		   	   
		   	   Connection con=null;PreparedStatement ps=null;int rs=0;
			   try {
				con=getInstanceConnection();
				ps=con.prepareStatement(EDIT_QUESTION_QUERY);
				ps.setString(1,question_text);
				ps.setString(2, service_id);
				ps.setString(3, subservice_id);
				ps.setInt(4, question_type);
				ps.setString(5, validation);
				ps.setString(6,options);
				ps.setString(7, help_text);
				ps.setInt(8, section_id);
				ps.setInt(9,question_id);
				rs=ps.executeUpdate();
				if(rs!=0) {
					json_response.addProperty("DATA","Question Edited Sucessfully");
				}else {
					json_response.addProperty("DATA","Question Editing Failure");
				}
				
				ps.close();
				con.close();
				 
				} catch (SQLException e) {
					 e.printStackTrace();
					 json_response.addProperty("DATA","Technical Error Occured");
				} finally {
						try {
							
							ps.close();
							con.close();
						}catch(Exception e) {
							e.printStackTrace();
						}
					}
		   	    
		   	    
		   	    return json_response;
	    	}//saveQuestion close
	    	
	    	
      
      public JsonObject deleteQuestion(int question_id) {
  		
  		JsonObject json_response=new JsonObject();
	   	   
	   	   Connection con=null;PreparedStatement ps=null;int rs=0;
		   try {
			con=getInstanceConnection();
			ps=con.prepareStatement(DELETE_QUESTION_QUERY);
			ps.setInt(1, question_id);
			rs=ps.executeUpdate();
			if(rs!=0) {
				json_response.addProperty("DATA","Question Deleted");
			}else {
				json_response.addProperty("DATA","Question Not  Delete");
			}
			
			ps.close();
			con.close();
			 
			} catch (SQLException e) {
				 e.printStackTrace();
				 json_response.addProperty("DATA","Technical Error Occured");
			} finally {
					try {
						
						ps.close();
						con.close();
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
	   	    
	   	    
	   	    return json_response;
  	}//saveQuestion close
  	
      
	    	
}
																																																																																																																																																																																																																				