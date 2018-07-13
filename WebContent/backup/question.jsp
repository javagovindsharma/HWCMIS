<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Questions</title>
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet" />
    <link href="css/all.css" rel="stylesheet" />
    <!-- Custom styles for this template -->
     <link href="css/style.css" rel="stylesheet" /> 
    <link href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css"/>
    
	 <script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
	 <script type="text/javascript"   src="CustomJS/Question.js"></script>
	  <script type="text/javascript"   src="CustomJS/common.js"></script>
	 <script type="text/javascript"  src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript"  src="https://code.jquery.com/jquery-1.12.4.js"></script>
	
	 
	  </head>

  <body  onload="questions();">
  	<div class="overAll">
    	<div class="container-fluid no-padding">
        	
            
            <jsp:include page="header.jsp"></jsp:include>
            
            <div class="col-sm-10 col-xs-12 no-padding right-portion">
            	
                <div class="col-sm-12 col-xs-12 top-heading ">
                <div class="col-sm-6 col-sm-offset-3 col-xs-6 col-xs-offset-3 text-center">Question </div>
                <div class="col-sm-3 col-xs-3 text-right"><a href="#" class="logout"><img src="images/logout.png" />Logout</a></div>
                </div>
                <div class="bottom-content col-sm-12 col-xs-12">
                	<div class="col-sm-12 no-padding upper-form"  >
                    	<div class="col-sm-12 col-xs-12">
                            <div class="col-sm-3 col-xs-12">
                                <div class="form-group">
                                    <label >Question Text:</label> 
                                    <input type="text"	id="id_ques_text" class="form-control login-text form-padding"	placeholder="What is Question" />
                                </div>
                            </div>
                           
                            <div class="col-sm-3 col-xs-12">
                                 <div class="form-group"  >  	
                                    <label >Services:</label>
                                    <select class="form-control login-text form-padding" id="servicesCell">
                                            <option>1</option>
                                     </select> 
                                     
                                  </div>
                             </div>
                             <div class="col-sm-3 col-xs-12">
                                  <div class="form-group" >
                                     <label >Sub Services:</label>
                                     <select class="form-control login-text form-padding" id="subServices">
                                            <option>1</option>
                                     </select> 
                                    
                                  </div>
                             </div>
                             <div class="col-sm-3 col-xs-12">
                                <div   class="form-group"  >
                                     <label >Section :</label>
                                      <select  class="form-control login-text form-padding"   id="id_section"></select>
                                 </div>
                            </div>
                         </div>
                         <div class="col-sm-12 col-xs-12">
                             <div class="col-sm-3 col-xs-12">
                                <div class="form-group"  >
                                     <label >Question Type :</label>
                                  <select class="form-control login-text form-padding" id="id_questiontype">
                                            <option>1</option>
                                    </select>        
                                  
                                </div>
                            </div>
                            
                            <div class="col-sm-3 col-xs-12">
                                <div class="form-group">
                                    <label >Validation:</label> 
                                    <input type="text"	id="id_validation" class="form-control login-text form-padding"	placeholder="5-10" />
                                </div>
                            </div>
                            
                            <div class="col-sm-3 col-xs-12">
                                <div class="form-group">
                                    <label >Options:</label> 
                                    <input type="text"	id="id_option" class="form-control login-text form-padding"	placeholder="option1,option2,option3.." />
                                </div>
                            </div>
                            
                            <div class="col-sm-3 col-xs-12">
                                <div class="form-group">
                                     <label >Help :</label>
                                     <textarea class="form-control login-text form-padding" rows="3" id="comment" placeholder="Help for Question"></textarea>
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
                   <div class="col-sm-12 no-padding bottom_table">
                      <div id="source" style="width: 100%; height: 250px; font-size: x-small; font-family: 'Segoe UI'; margin-left: 0%; border-color: white; border-width: thin; overflow: auto; border-style: groove; overflow: auto; float:left;">
                    	 <!-- <table class="table table-bordered"  id="tbl_id" border="1"> --> 
                        <table id="tbl_id" class="display nowrap" style="width:100%;"   border="1"> 
		                           <thead style="background-color: green;">
		                             <tr >
			                               
			                               <th >question_id</th>
			                               <th >section_id</th>           
			                               <th >service_id</th>
			                               <th >subservice_id</th>
			                              <th >question_text</th> 
			                               <th >question_type</th>
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
		                           <tbody >
		                           
		                           </tbody>
		                                  
		                    </table>
		                   
                       </div>
                    </div>
                </div>
              
            </div>
        </div>
    </div>
    
<!-- Bootstrap core JavaScript
    ================================================== -->
    <!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>-->
   	<script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
   
   
  </body>
</html>
