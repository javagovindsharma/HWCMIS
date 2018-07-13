<!DOCTYPE html>
<%@page import="com.tattva.dao.connectionProvider,java.sql.*"%>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="images/nhm_logo.png">
    <title>Question</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet" />    
    <link href="css/all.css" rel="stylesheet" />
    
    <!-- Custom styles for this template -->
    <link href="css/style.css" rel="stylesheet" />  
    <link href="css/buttons.dataTables.min.css" rel="stylesheet" />
	 
	 <script type="text/javascript"  src="CustomJS/Question.js"></script>
	 <script type="text/javascript"  src="CustomJS/common.js"></script>
  </head>

  <body   onload="questions();">
  	<div class="overAll">
    	<div class="container-fluid no-padding">
        	<jsp:include page="header.jsp"></jsp:include>
            <div class="col-sm-10 col-xs-12 no-padding right-portion">
            	
                <div class="col-sm-12 col-xs-12 top-heading ">
                <div class="col-sm-6 col-sm-offset-3 col-xs-6 col-xs-offset-3 text-center">Section </div>
                <div class="col-sm-3 col-xs-3 text-right"><a href="#" class="logout"><img src="images/logout.png" />Logout</a></div>
                </div>
                <div class="bottom-content col-sm-12 col-xs-12">
                	<div class="col-sm-12 col-xs-12 no-padding upper-form">
                	
                    	<div class="col-sm-12 col-xs-12">
                        	<div class="col-sm-3 col-xs-12">
                                <div class="form-group">
                                    <label >Section Name:</label> 
                                    <input type="text"	id="id_ques_text" class="form-control login-text form-padding"	placeholder="What is Question" />
                                </div>
                            </div>
                            <div class="col-sm-3 col-xs-12">
                                <div class="form-group">
                                    <label >Services:</label> 
                                    <select id="servicesCell" name="servicesCell[]" class="selectpicker form-control" multiple>
                                      
                                    </select>

                                </div>
                            </div>
                           
                            <div class="col-sm-3 col-xs-12">
                                 <div class="form-group">  	
                                    <label >Sub Services:</label>
                                    <select  id="subServices" name="subServices[]"  class="selectpicker form-control" multiple>
                                      
                                    </select>
                                  </div>
                             </div>
                            <div class="col-sm-3 col-xs-12">
                                <div class="form-group">
                                     <label >Status :</label>
                                     <select class="form-control login-text form-padding" id="id_section">
                                            
                                     </select>
                                </div>
                            </div>
                         </div>
                                               
                         <div class="col-sm-12 col-xs-12 button-wrapper">
                            <div class="form-group text-center">
                        		<button class="btn btn-primary login-btn save-btn" id="btn_save"  onclick="validationSave();">Save</button>
                        		<button class="btn btn-primary login-btn save-btn" id="btn_edit"  onclick="editingQuestion();">Edit</button>
                                <span >&nbsp;</span><input type="hidden" id="id_hidden" value="">
                                <button class="btn btn-info login-btn save-btn" id="btn_rest"  onclick="buttonRest();">Reset</button>
                        	</div>
                        </div>
                      
					</div><!---->
					
					<div  style="width: 97%;height: ">
					<div class="col-sm-12 no-padding bottom_table">
                    	<div class="whole whole2"  style="font-size: 12px;">                  	
                        
                        <table id="example" class="display table table-striped" style="width:100%">
                            <thead> <tr><th>question_id</th>
					    	  		    <th>section_id</th>
						    	  		<th>service_id</th>
						    	  		<th>subservice_id</th>
						    	  		<th>question_text</th>
						    	  		<th>question_type</th>
						    	  		<th >options</th>
						    	  		<th >Created Date</th>
						    	  		<th >updated_date</th>
						    	  		<th >position</th>
						    	  		<th >validation</th>
						    	  		<th >help_text</th>
						    	  		<th >status</th>
						    	  		<th ><b>Action</b></th>
						    	  	</tr>
	                            </thead>
                            <tbody>
                                                              
                                <%
                                  Connection con=new connectionProvider().getInstanceConnection();
                                  Statement st=con.createStatement();
                                  ResultSet rs=st.executeQuery("SELECT * FROM question_master");
                                
                                  while(rs.next()){
                               %>
	                               <tr><td><%=rs.getString("question_id") %></td>
	                               <td><%=rs.getString("section_id") %></td>
	                               <td><%=rs.getString("service_id") %></td>
	                               <td><%=rs.getString("subservice_id") %></td>
	                               <td><%=rs.getString("question_text") %></td>
	                               <td><%=rs.getString("question_type") %></td>
	                               <td><%=rs.getString("options") %></td>
	                               <td><%=rs.getString("created_date") %></td>
	                               <td><%=rs.getString("updated_date") %></td>
	                               <td><%=rs.getString("position") %></td>
	                              <td><%=rs.getString("validation") %></td>
	                              <td><%=rs.getString("help_text") %></td>
	                              <td><%=rs.getString("status") %></td>
	                              <td><a onclick="editquestion(<%=rs.getString("question_id") %>)">edit</a>&nbsp;
	                              <a onclick='deleteQuestion(<%=rs.getString("question_id") %>)'>delete</a></td></tr>
                               <% 	  
                                  }
                                %>
                              
                               </tbody>
                            </table>
                         </div> 
                   </div><!-- - -->
                </div>
            </div>
        </div>
    </div>
    </div>
<!-- Bootstrap core JavaScript
    ================================================== -->
   
   	<script src="js/jquery.js"></script> 
    <script src="js/jquery.dataTables.min.js"></script>
    <script src="js/dataTables.buttons.min.js"></script>
    <script src="js/jszip.min.js"></script>
    <script src="js/pdfmake.min.js"></script>
    <script src="js/vfs_fonts.js"></script>
    <script src="js/buttons.html5.min.js"></script>
    <!----> 
    <script src="js/custom.js"></script>
    <script src="js/bootstrap.min.js"></script>   
  </body>
</html>

