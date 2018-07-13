<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    
    <title>Login</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet" />
    <link href="css/ui.css" rel="stylesheet" />
    <link href="css/all.css" rel="stylesheet" />
    <!-- Custom styles for this template -->
    <link href="css/style.css" rel="stylesheet" />
  </head>

  <body>
  <div class="overAll">
    	<div class="container-fluid no-padding upper-login-wrapper">
            
        	<div class="login-wrapper">
                <!---->
                <div class="col-sm-12 no-padding login-topbar">
                	<div class="col-sm-12 no-padding text-center logoimg-wrapper">
                        <img src="images/logo.png" />
                    </div> 
                	<div class="col-sm-12 no-padding text-center logotext-wrapper">
                        <h4>Health & Wellness Centre</h4><br />
                        <p>UTTAR PRADESH</p>
                    </div>
                                      
        		</div>
                <!---->
                <div class="login-box col-md-offset-4 col-sm-offset-3 col-md-4 col-sm-6 col-xs-12 no-padding">
              		<form  action="loginurl" method="POST" role="form" data-toggle="validator">
                        <div class="header-login text-center">Login</div>
                        <%session.getAttribute("Error"); %>
                        <div class="body-login">
                            <div class="form-group">
                                <label for="user name">User Name:</label>
                                <span class="wrap_icon">
                                <input type="text" name="username" id="id_user" class="form-control login-text" placeholder="User Name" required />
                                <span class="input_icon"><i class="fas fa-user"></i></span>
                                </span>
                            </div>
                            <div class="form-group">
                                <label for="password">Password:</label>
                                <span class="wrap_icon">
                                <input type="password" name="password" id="id_pass"  class="form-control login-text" placeholder="Password" required />
                                 <span class="input_icon"><i class="fas fa-unlock-alt"></i></span>
                                </span>
                            </div>
                            <div class="form-group text-center">
                                <button class="btn btn-primary btn-block login-btn" onclick="loginValidation();">Login</button>
                            </div>
                            
                        </div> 
                    </form>  
                </div> 
            </div>           
   		</div>   
  </div>
  	
<!-- Bootstrap core JavaScript
    ================================================== -->
    
   	<script src="js/jquery.js"></script>     
     <script src="js/custom.js"></script>
    <script src="js/bootstrap.min.js"></script>
      
  </body>
</html>

