package com.tattva.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.json.JSONArray;
import org.json.JSONObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;


public class ReferalDao {

	
	
	
	/**
	 * 
	 * 
	 * @author Govind
	 * Date BAse Query
	 */
	
	public static String DISTRICT_QUERY="SELECT dst_id,district_name FROM district    order by district_name";
	public static String BLOCK_QUERY="SELECT blk_id,block_name FROM block   where district_id=? order by block_name";
	public static String SUBCENTER_QUERY="SELECT id,sub_center_name FROM sub_center_master   where  block_id=? order by sub_center_name";
	public static String VILLAGE_QUERY="SELECT id,village_name FROM `village` WHERE sub_center_id=?   order by village_name";
	public static String ASHA_QUERY="SELECT id,name_of_asha FROM `asha_master` WHERE village_id=?  order by name_of_asha";
	
	
	
	//here code 
	
	public JsonObject getDistrict() {
		 JsonObject json_response=new JsonObject();
	   	    JsonArray data_json=new JsonArray();
		   System.out.println("getDistrict data");
				
		    Connection con=null;PreparedStatement st=null;ResultSet rs=null;
			   try {
				con=new connectionProvider().getInstanceConnectionNHM();
				st=con.prepareStatement(DISTRICT_QUERY);
				rs=st.executeQuery();
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
	}//getDistrict
	
	
	public JsonObject getBlock(int id_district) {
		 JsonObject json_response=new JsonObject();
	   	    JsonArray data_json=new JsonArray();
		   System.out.println("getBlock data");
				
		    Connection con=null;PreparedStatement st=null;ResultSet rs=null;
			   try {
				con=new connectionProvider().getInstanceConnectionNHM();
				st=con.prepareStatement(BLOCK_QUERY);
				   st.setInt(1, id_district);
				rs=st.executeQuery();
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
	}//getBlock
	
	
	
	public JsonObject getSubCenter(int id_block) {
		 JsonObject json_response=new JsonObject();
	   	    JsonArray data_json=new JsonArray();
		   System.out.println("my Section data");
				
		    Connection con=null;PreparedStatement st=null;ResultSet rs=null;
			   try {
				con=new connectionProvider().getInstanceConnectionNHM();
				st=con.prepareStatement(SUBCENTER_QUERY);
				   st.setInt(1, id_block);
				rs=st.executeQuery();
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
	}//getSubCenter
	
	
	
	public JsonObject getVillage(String subcenter_id) {
		 JsonObject json_response=new JsonObject();
	   	    JsonArray data_json=new JsonArray();
		   System.out.println("my Section data"+subcenter_id);
				
		    Connection con=null;PreparedStatement st=null;ResultSet rs=null;
			   try {
				con=new connectionProvider().getInstanceConnectionNHM();
				System.out.println("Query-->"+VILLAGE_QUERY);
				st=con.prepareStatement(VILLAGE_QUERY);
				    st.setString(1, subcenter_id);
				 rs=st.executeQuery();   
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
	}//getVillage
	
	
	
	public JsonObject getAsha(String village_id) {
		 JsonObject json_response=new JsonObject();
	   	    JsonArray data_json=new JsonArray();
		  
	   	    Connection con=null;PreparedStatement st=null;ResultSet rs=null;
			   try {
				con=new connectionProvider().getInstanceConnectionNHM();
				st=con.prepareStatement(ASHA_QUERY);
				    st.setString(1, village_id);
				 rs=st.executeQuery();   
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
	}//getAsha
	
	
	
	
	
	public JsonObject getReferedDataDao(int subcenter_id,int village_id,int asha_id,int service_id,int subService_id,String from_date,String to_date) {
		
		JsonObject datajson=new JsonObject();
		JsonArray jsonArray=new JsonArray();
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		
		
		
		
		String Query="select hw_household_data.households_member_unique_id,hw_household_data.person_name,village.village_name,";
		       Query+=" asha_master.name_of_asha,hwc_referal.refered_date,hwc_services_master.service_name,";
		       Query+="  hwc_subservices_master.subservices_name,hwc_referal.status_updated,hwc_referal.referal_by";
		       Query+="  from sub_center_master  ";
		       Query+=" INNER JOIN hw_household_data   on hw_household_data.subcenter_id=sub_center_master.id";
		       Query+="  INNER JOIN hw_master_data  on hw_master_data.household_roster_id=hw_household_data.household_roster_id";
		       Query+="  INNER JOIN village on village.id=hw_master_data.village_id";
		       Query+="  INNER join asha_master on asha_master.id=hw_master_data.asha_id";
		       Query+="  LEFT join  hwc_referal on hwc_referal.patient_id=hw_household_data.households_member_unique_id"; 
		       Query+="  LEFT join hwc_services_master on hwc_services_master.id=hwc_referal.service_id";
		       Query+="  LEFT join hwc_subservices_master on hwc_subservices_master.id=hwc_referal.subservice_id";

		       if(subcenter_id>0|| village_id>0|| asha_id>0|| service_id>0 || subService_id>0 || from_date.length()>2 || to_date.length()>2)
		            Query+="  where"; 
		
		       if(subcenter_id>0) 
		    	   Query+="  sub_center_master.id="+subcenter_id;
		        
		       if(village_id>0) {
		    	
		    	   if(subcenter_id>0) {
		    		   Query+="   AND  ";
		    	   }
		    	   
		    	   Query+="  village.id="+village_id;
		       }
		       
		       if(asha_id>0) {
		    	   if(subcenter_id>0 || village_id>0) {
		    		   Query+="   AND  ";
		    	   }
		    	   Query+="  asha_master.id="+asha_id;
		       }
		       
		       if(service_id>0) {
		    	   if(asha_id>0 || subcenter_id>0 || village_id>0) {
		    		   Query+="   AND  ";
		    	   }
		         Query+="  hwc_referal.service_id="+service_id;
		       }
		       if(subService_id>0) {
		    	   if(service_id>0 || asha_id>0 || subcenter_id>0 || village_id>0) {
		    		   Query+="   AND  ";
		    	   }
		          Query+="   hwc_referal.subservice_id="+subService_id;
		       }
		       if(from_date.length()>2) {
		    	   if(subService_id>0 || service_id>0 || asha_id>0 || subcenter_id>0 || village_id>0) {
		    		   Query+="   AND  ";
		    	   }
		           Query+="   CONVERT(hwc_referal.refered_date, DATE)>'"+from_date+"'";
		       }
		       if(to_date.length()>2) {
		    	   if(from_date.length()>2 || subService_id>0 || service_id>0 || asha_id>0 || subcenter_id>0 || village_id>0) {
		    		   Query+="   AND  ";
		    	   }
		    	   Query+="   CONVERT(hwc_referal.refered_date, DATE)>'"+to_date+"'";
		       }
		
	System.out.println("***Referal*Query************"+Query);	
				  try {
					  
					  con=new connectionProvider().getInstanceConnectionNHM();
					  st=con.createStatement();
					  rs=st.executeQuery(Query);
	  
					  while(rs.next()) {
						  JsonObject childjson=new JsonObject();
						
						   if(rs.getString("households_member_unique_id")!=null)
								  childjson.addProperty("households_member_unique_id", rs.getString("households_member_unique_id"));
						   else		  
								  childjson.addProperty("households_member_unique_id", "");
							
						   if(rs.getString("person_name")!=null)
								  childjson.addProperty("person_name", rs.getString("person_name"));
						   else	
								  childjson.addProperty("person_name", " ");
								
						   
						   if(rs.getString("village_name")!=null)
								  childjson.addProperty("village_name", rs.getString("village_name"));
						   else		  
								  childjson.addProperty("village_name", "");
								
						   
						   if(rs.getString("name_of_asha")!=null)
								  childjson.addProperty("name_of_asha", rs.getString("name_of_asha"));
						   else		  
								  childjson.addProperty("name_of_asha", " ");
								
						   if(rs.getString("refered_date")!=null)
								  childjson.addProperty("refered_date", rs.getString("refered_date"));
						   else		  
								  childjson.addProperty("refered_date", " " );
								
						   if(rs.getString("service_name")!=null) 
								  childjson.addProperty("service_name", rs.getString("service_name"));
						   else		  
								  childjson.addProperty("service_name", " ");
								
						   if(rs.getString("subservices_name")!=null) 
								  childjson.addProperty("subservices_name", rs.getString("subservices_name"));
						   else
								  childjson.addProperty("subservices_name", " ");
						   
						   if(rs.getString("status_updated")!=null)   
								  childjson.addProperty("status_updated", rs.getString("status_updated"));
						   else
							   childjson.addProperty("status_updated", " ");
						   
						   if(rs.getString("referal_by")!=null)
							    childjson.addProperty("referal_by", rs.getString("referal_by"));
						   else
						         childjson.addProperty("referal_by", " ");
						   
						   
						jsonArray.add(childjson);
					  }
					 
					  datajson.add("DATA", jsonArray);
					  
					  
				  }catch(Exception e) {
					  e.printStackTrace();
				  }
				  
		
		  return datajson;
		
	}//getReferedDataDao
	
	
	
	
	
}
