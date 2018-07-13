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
                <div class="col-sm-6 col-sm-offset-3 col-xs-6 col-xs-offset-3 text-center">DashBoard</div>
                <div class="col-sm-3 col-xs-3 text-right"><a href="#" class="logout"><img src="images/logout.png" />Logout</a></div>
                
                </div>
                 <div class="bottom-content col-sm-12 col-xs-12">
                	<div class="col-sm-12 col-xs-12 no-padding upper-form">
                	
                    	<div class="col-sm-12 col-xs-12">
                               <h1>Welcome to Admin</h1>
                         </div>
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

