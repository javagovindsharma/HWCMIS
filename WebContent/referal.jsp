<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="images/nhm_logo.png">
    <title>Referal </title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet" />    
    <link href="css/all.css" rel="stylesheet" />
    
    <!-- Custom styles for this template -->
    <link href="css/style.css" rel="stylesheet" />  
    <link href="css/buttons.dataTables.min.css" rel="stylesheet" />
	<link href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.1/css/bootstrap.css">
 
 
 
    <script type="text/javascript"  src="js/jquery-3.3.1.min.js"></script>
   
 	 	<style type="text/css">
 	 	
 	 	  .dataTable{
 	 	      margin-bottom: 0px; 
 	 	  }
 	 	 .pagination>li {
		    padding: 0px;
		    display: inline;
		    border: none;
		  }
 	 	</style>
  </head>

  <body  >
  	<div class="overAll">
    	<div class="container-fluid no-padding">
        	<jsp:include page="header.jsp"></jsp:include>
            <div class="col-sm-10 col-xs-12 no-padding right-portion">
            	
                <div class="col-sm-12 col-xs-12 top-heading ">
                <div class="col-sm-6 col-sm-offset-3 col-xs-6 col-xs-offset-3 text-center"><b>Referal</b></div>
                <div class="col-sm-3 col-xs-3 text-right"><a href="logout" class="logout"><img src="images/logout.png" />Logout</a></div>
                </div>
                <div class="bottom-content col-sm-12 col-xs-12">
                	<div class="row upper-form">
                	
                    	<div class="col-sm-12 col-xs-12">
                    	<div class="col-sm-2 col-xs-6">
                                <div class="form-group">
                                    <label >District </label> 
                                    <select class="form-control login-text form-padding" id="id_district"  onchange="block();">
                                            
                                     </select>
                                </div>
                            </div>
                            <div class="col-sm-2 col-xs-6">
                                <div class="form-group">
                                    <label >Block</label> 
                                    <select class="form-control login-text form-padding" id="id_block"  onchange="subcenter();">
                                            
                                     </select>
                                </div>
                            </div>
                        	<div class="col-sm-2 col-xs-6">
                                <div class="form-group">
                                    <label >Sub-Center</label> 
                                    <select class="form-control login-text form-padding" id="id_subcenter"  onchange="getVillage();">
                                            
                                     </select>
                                </div>
                            </div>
                            <div class="col-sm-2 col-xs-6">
                                <div class="form-group">
                                    <label >Village</label> 
                                  <select class="form-control login-text form-padding" id="id_village"  onchange="getAsha();">
                                            
                                     </select>
                                </div>
                            </div>
                            <div class="col-sm-2 col-xs-6">
                                <div class="form-group">
                                    <label >ASHA</label> 
                                   <select class="form-control login-text form-padding" id="id_asha">
                                            
                                     </select>
                                </div>
                            </div>
                           <div class="col-sm-2 col-xs-6">
                                <div class="form-group">
                                    <label >Services:</label> 
                                  <select class="form-control login-text form-padding" id="servicesCell">
                                            
                                     </select>

                                </div>
                            </div>
                           
                         </div>
                         <div class="col-sm-12 col-xs-12">
                             <div class="col-sm-3 col-xs-12">
                                 <div class="form-group">  	
                                    <label >Sub Services:</label>
                                   <select class="form-control login-text form-padding" id="subServices">
                                            
                                     </select>
                                  </div>
                             </div>
                            <!--  <div class="col-sm-3 col-xs-12">
                                <div class="form-group">
                                     <label >Encounter :</label>
                                     <select class="form-control login-text form-padding" id="id_encounter">
                                            
                                     </select>
                                </div>
                            </div> -->
                             <div class="col-sm-2 col-xs-6">
                                <div class="form-group">
                                 <label >Form Date :</label>
					             
					                    <input type='date' class="form-control"   id="id_form_date"/>
					                  
					                
					            </div>
					           
                            </div>
                            <div class="col-sm-2 col-xs-6">
                               <div class="form-group">
                                 <label >To Date :</label>
					                    <input type='date' class="form-control"  id="id_to_date" />
					             </div>
                            </div>
                            
                            
                           <div class="col-sm-2 col-xs-6">
                              <button class="btn btn-primary login-btn save-btn" id="btn_save"  onclick="searchReferal();">Search</button>
                            </div>
                             <div class="col-sm-2 col-xs-6">
                              <button class="btn btn-danger login-btn save-btn" id="btn_save"  onclick="location.reload();">Clear</button>
                            </div>
                        </div>
                       
                       
                      
					</div><!---->
					
					<div class="row">
					<div class="col-sm-12 no-padding bottom_table">
                    	<div class="whole whole2"  style="font-size: 12px;">                  	
                        
                       
                        </div> 
                   </div><!-- - -->
                   
           <!-- --Table -------- --> 
            <div class="col-sm-12 col-xs-12 upper-form"> 
               <div  id="tbl_div">     
             
                  <!-- <table id="example"  style="width:100%">
						    <thead>
						      <tr>
						        <th>Patient ID</th>
						        <th>Patient Name</th>
						        <th>Service</th>
						        <th>Sub-Service</th>
						        <th>Village</th>
						        <th>Referred Date</th>
						        <th>Status</th>
						        <th>Status UpdateDate</th>
						       </tr>
						    </thead>
						    <tbody>
						      
						    </tbody>
						  </table> -->
                   </div>
                </div><!-- upper-form up to table- -->
                </div>
                
            </div>
        </div>
    </div>
    </div>
<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- <script src="js/jquery.js"></script> 
    <script type="text/javascript"  src="js/bootstrap.min.js"></script>
    <script type="text/javascript"  src="js/jszip.min.js"></script>
    <script type="text/javascript"  src="js/pdfmake.min.js"></script>
    <script type="text/javascript"  src="js/vfs_fonts.js"></script> 
    <script type="text/javascript"  src="CustomJS/referal.js"></script> 
 	<script type="text/javascript"  src="js/jquery.dataTables.min.js"></script>
    <script type="text/javascript"  src="js/dataTables.buttons.min.js"></script> 
    <script src="js/buttons.html5.min.js"></script>-->
    
   	 <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
   <script src="js/jquery-3.3.1.js"></script> 
    <script src="js/jquery.dataTables.min.js"></script>
	<script src="js/dataTables.bootstrap.min.js"></script>
    <script src="js/dataTables.buttons.min.js"></script>
	<script src="js/buttons.bootstrap.min.js"></script>
	<script src="js/jquery-ui.js"></script>
     <script src="js/custom.js"></script>
    <script src="js/jszip.min.js"></script>
    <script src="js/pdfmake.min.js"></script>
    <script src="js/vfs_fonts.js"></script>
	<script src="js/buttons.html5.min.js"></script>
	<script src="js/buttons.print.min.js"></script>
	<script src="js/buttons.colVis.min.js"></script>
    <script type="text/javascript"  src="CustomJS/referal.js"></script> 
  </body>
</html>

