
 function  section() {
     $.ajax({ 
    	
    	 type:"POST",
    	 url: "Question?method=setSection",
         contentType: "application/json", 
     	 data: JSON.stringify(data),
		 cache: false,
        success: function(data){
           alert("done");
           var strData= JSON.parse(data);
           var val;
           $.each(strData['DATA'], function (i, val) {
        	   val+="<option  value="+i+">"+val+"</option>";
           })
           $("#section").append(val);
        },
        error: function (data) {
            alert("Failed");
            
        }
     });
}


	function setvalueQuestions(){
		$("#btn_save").show();
		 $("#btn_edit").hide();
		Section();
		service();
		subservice();
		setQuestion();
	}
	
	function questions(){
		//questionTable();
		setvalueQuestions();
		//getdata();
	        
	 }//question close
  
   
     
     function deleteQuestion(){
    	 deleteTableRecord('example');
     }
     
     function deleteTableRecord(tableId) {
 		if(document.getElementById(tableId)!=null){
 			var table = document.getElementById(tableId);
 			var rows = table.getElementsByTagName('tr');
 			
 			for ( var i = 1; i < rows.length; i++) {
 				rows[i].i = i;
 				rows[i].onclick = function() {
 				var question_id=table.rows[this.i].cells[0].innerHTML;
 					
 					 var result= confirm("Are Sure for deActivate Records"+question_id);
 					 if(result==true){
 						var	data = {
 								question_id:question_id	
 			   	    	};
 			   	        $.ajax({
 			   	        	type:"POST",
 			   	            url: "Question?method=deleteQuestion",
 			   	            contentType: "application/json", 
 			   	           	data: JSON.stringify(data),
 			   				cache: false,
 			   	            success: function (data) {
 			   	              
 			   	               var strData= JSON.parse(data);
 			                    alert(strData['DATA']);
 			                   location.reload();
 			                  
 			                },
 			   	            error: function (data) {
 			   	                alert("Failed");
 			   	            }
 			   	        })
 					 }//result close for if
 					 
 	             };
 			}
 		}
 	}
     
     
  
     function buttonRest(){
    
    	  $("#id_ques_text").val("");
    	  $("#comment").val("");
    	  $("#id_validation").val("");
    	  $("#id_option").val("");
    	  setvalueQuestions();
    	  $("#btn_save").show();
		  $("#btn_edit").hide();
			 
     }
     
     
     
     
     function validationSave(){
    	 
    	 var quesText=$("#id_ques_text").val();
   	     var help= $("#comment").val();
   	     var question=$("#id_questiontype").val();
   		 var subservice=$('#subServices> option:selected');//$("#subServices").val();
   		 var service=$('#servicesCell > option:selected');//$("#servicesCell").val();
   	     var section=$("#id_section").val();
   	     var validation=$("#id_validation").val();
   	  	 var option=$("#id_option").val();
   	  	 
   	  	if(question=="Technical Error"  && subservice=="Technical Error" && service=="Technical Error" && section=="Technical Error"){
   	  		   alert("Technical Problem !");
   	  		location.reload();
   	  		
   	  	 }else  if(quesText==null || quesText.length < 1){
   	    	 alert(" Must be Fill Question Text ?");
   	    	$("#id_ques_text").focus();
   	    	 return false;
   	     }else if(service.length == 0){
   	    	 alert(" Must be Select Any Services ?");
   	    	$("#servicesCell").focus();
   	    	 return false;
   	     }else if(subservice.length == 0){
   	    	 alert(" Must be Select Any Sub-Services ?");
   	    	$("#subServices").focus();
   	    	 return false;
   	     }else if(parseInt(section)==-1){
   	    	 alert(" Must be Select Any Section ?");
   	    	$("#id_section").focus();
   	    	 return false;
   	     }else if(parseInt(question)==-1){
   	    	 alert(" Must be Select Any Question Type ?");
   	    	$("#id_questiontype").focus();
   	    	
   	    	 return false;
   	     }else if(help==null || help.length < 1){
   	    	 alert(" Must be Fill Help  Related to Question ?");
   	    	$("#comment").focus();
   	    	 return false;
   	     }/*else if((validation==null || validation.length < 1) && (option==null || option.length < 1)){
   	    	validation=" ";option=" ";
   	    	 
   	     }*/else{
   	    	 
   	    	subservice=$("#subServices").val();
   	    	service= $("#servicesCell").val();
   	    	 
   	    	var subservicedata=String(subservice);
   	    	var servicedata=String(service);
   	    	 
   	    	var	data = {
   	    			quesText:quesText,
   	    			help:help,
   	    			question:question,
   	    			subservice:subservicedata,
   	    			service:servicedata,
   	    			section:section,
   	    			validation:validation,
   	    			option:option
   	    	};
   	        $.ajax({
   	        	type:"POST",
   	            url: "Question?method=saveQuestionMethod",
   	            contentType: "application/json", 
   	           	data: JSON.stringify(data),
   				cache: false,
   	            success: function (data) {
   	              
   	               var strData= JSON.parse(data);
                    alert(strData['DATA']);
                    buttonRest();
                  
                },
   	            error: function (data) {
   	                alert("Failed");
   	            }
   	        })
   	     }
   	     
   	     
   	     
     }
     
   
     function editquestion(){
    	 alert();
  	    addRowHandlers('example');
    }

      
      
      function addRowHandlers(tableId) {
     		if(document.getElementById(tableId)!=null){
     			var table = document.getElementById(tableId);
     			var rows = table.getElementsByTagName('tr');
     			
     			for ( var i = 1; i < rows.length; i++) {
     				
     				rows[i].i = i;
     				rows[i].onclick = function() {
     					          												
     					var question_id=table.rows[this.i].cells[0].innerHTML;
     					var section_id=table.rows[this.i].cells[1].innerHTML;
     					var service_id=table.rows[this.i].cells[2].innerHTML;
     					var subservice_id=table.rows[this.i].cells[3].innerHTML;
     					var question_text=table.rows[this.i].cells[4].innerHTML;
     					var questionType=table.rows[this.i].cells[5].innerHTML;
     					var validation=table.rows[this.i].cells[10].innerHTML;
     					var options=table.rows[this.i].cells[6].innerHTML;
     					var help=table.rows[this.i].cells[11].innerHTML;
     	 setEditQuestion(question_id,section_id,service_id,subservice_id,question_text,questionType,validation,options,help);
     					    
     	              	};
     			}
     		}
     	}
      
      
     function  setEditQuestion(question_id,section_id,service_id,subservice_id,question_text,questionType,validation,options,help){
    	
    	 $("#id_section").val(section_id);
    	 $("#servicesCell").val(service_id);
    	 $("#subServices").val(subservice_id);
    	 $("#id_ques_text").val(question_text);
    	 $("#id_questiontype").val(questionType);
    	 $("#id_validation").val(validation);
    	 $("#id_option").val(options);
    	 $("#comment").val(help);
    	 $("#id_hidden").val(question_id);
    	 
    	 $("#btn_save").hide();
    	 $("#btn_edit").show();
    	 
    	 
      }
      
     
       function editingQuestion(){
    	   var quesText=$("#id_ques_text").val();
     	     var help= $("#comment").val();
     	     var question=$("#id_questiontype").val();
     		 var subservice=$("#subServices").val();
     		 var service=$("#servicesCell").val();
     	     var section=$("#id_section").val();
     	     var validation=$("#id_validation").val();
     	  	 var option=$("#id_option").val();
      	     var question_id=$("#id_hidden").val();
      	     
      	    var subservicedata=String(subservice);
  	    	var servicedata=String(service);
      	     
     	      var	data = {
     	    		    question_id:question_id,
  	    			quesText:quesText,
  	    			help:help,
  	    			question:question,
  	    			subservice:subservicedata,
  	    			service:servicedata,
  	    			section:section,
  	    			validation:validation,
  	    			option:option
  	    	};
    	        $.ajax({
    	        	type:"POST",
    	            url: "Question?method=editQuestion",
    	            contentType: "application/json", 
    	           	data: JSON.stringify(data),
    				cache: false,
    	            success: function (data) {
    	              
    	               var strData= JSON.parse(data);
                     alert(strData['DATA']);
                    location.reload();
                   
                 },
    	            error: function (data) {
    	                alert("Failed");
    	            }
    	        })
      	  
       }
     
      
     
       
       
       
       
       
       
       
       
       function getdata() {
    	    $.ajax({
    	        type: "POST",
    	        url: "Question?method=getQuestion", //controller URL
    	        contentType: "application/json; charset=utf-8",
    	        dataType: "json",

    	        success: function(results) {
    	            console.log(results)
    	            var success = results.success;
    	            if (success) {
    	                var finaldata = "<thead><tr><th>ID</th><th>data1</th><th>data2</th><th>Update</th></tr></thead><tbody>"; //data
    	                var data = results.message;
    	                data = jQuery.parseJSON(data);
    	                alert(data);
    	                for (var i = 0; i < data.length; i++) {
    	                    var value = data[i];
    	                    finaldata = finaldata + "<tr><td>" + value.question_id + "</td><td>" + value.section_id + "</td><td>" + value.service_id + "</td><td>"+subservice_id+"</td>" +
    	                     "<td>" + value.question_text + "</td><td>" + value.question_type + "</td><td>" + value.options + "</td><td>" + value.created_date + "</td>"+
    	                      +"<td>" + value.updated_date + "</td><td>" + value.position + "</td><td>" + value.validation + "</td><td>" + value.help_text + "</td><td>" + value.status + "</td></tr>";
    	                }
    	                finaldata = finaldata + "</tbody>";
    	                $("#tbl_id").html(finaldata);
    	                $("#tbl_id").DataTable();
    	            }
    	        },
    	        error: function(data) {
    	            alert("fail");
    	            console.log('ajax call error');

    	        }
    	    });
    	}
       
       
   
       
   
       
/*       function questionTable(){
    		 
    		//table json
    		 
    		 var	data = {};
    	        $.ajax({
    	        	type:"POST",
    	            url: "Question?method=getQuestion",
    	            contentType: "application/json", 
    	           	data: JSON.stringify(data),
    				cache: false,
    	            success: function (data) {
    	            	
    	                var strData= JSON.parse(data);var count=0;
    	                $.each(strData['Question'], function (i, val) {
    	                	$("#example").empty();
    	                	$("table td").addClass("table table-bordered");
    	             	   var tableHead="<thead style='background-color: green;'><tr> <th class='valign'>question_id</th>";
    	                     tableHead=tableHead+" <th class='valign'>section_id</th>";           
    	                     tableHead=tableHead+"<th class='valign'>service_id</th>";
    	                     tableHead=tableHead+"<th class='valign'>subservice_id</th>";
    	                     tableHead=tableHead+" <th class='valign'>question_text</th>"; 
    	                     tableHead=tableHead+"<th class='valign'>question_type</th>";
    	                     tableHead=tableHead+" <th class='valign'>options</th> ";          
    	                     tableHead=tableHead+"<th class='valign'>Created Date</th>";
    	                     tableHead=tableHead+" <th class='valign'>updated_date</th>";
    	                     tableHead=tableHead+"<th class='valign'>position</th>";
    	                     tableHead=tableHead+"<th class='valign'>validation</th>";   
    	                     tableHead=tableHead+"<th class='valign'>help_text</th>  ";
    	                     tableHead=tableHead+" <th class='valign'>status</th> "; 
    	                     tableHead=tableHead+" <th class='valign'><b>Action</b></th></tr></thead>";
    	                     
    	                    $("#example").append(tableHead);
    	                	var data=strData['Question'];
    	                	 var TableRow = "<tr>";var values=0;
    	                	
    	                	 for (var i = 0; i < data.length; i++) {
    	                		var TableRow = "<tr>";
    	                	      TableRow += "<td>" + data[i].question_id + "</td>";
    	                	 	  TableRow += "<td>" + data[i].section_id + "</td>";
    	                		  TableRow += "<td>" + data[i].service_id  + "</td>";
    	                		  TableRow += "<td>" + data[i].subservice_id  + "</td>";
    	                		  TableRow += "<td>" +  data[i].question_text + "</td>";
    	                		  TableRow += "<td>" +  data[i].question_type + "</td>";
    	                		  TableRow += "<td>" + data[i].options  + "</td>";
    	                		  TableRow += "<td>" + data[i].created_date  + "</td>";
    	                		  TableRow += "<td>" + data[i].updated_date  + "</td>";
    	                		  TableRow += "<td>" + data[i].position  + "</td>";
    	                          TableRow += "<td>" + data[i].validation + "</td>";
    	                          TableRow += "<td>" + data[i].help_text + "</td>";
    	      	            	  TableRow += "<td>" + data[i].status + "</td>";
    	                 	TableRow += "<td><a onclick='editquestion()'>edit</a>" +
    	                			"&nbsp;<a onclick='deleteQuestion()'>delete</a></td></tr>";
    	                               	
    	                     $("#example").append(TableRow);
    	                 }
    	                	
    	                });
    	                $('#tbl_id').DataTable( {
    	        	        dom: 'Bfrtip',
    	        	        buttons: [
    	        	            'copy', 'csv', 'excel', 'pdf', 'print'
    	        	        ]
    	        	    } );
    	               // tbl_id
    	             },
    	            error: function (data) {
    	                alert("Failed");
    	            }
    	        })
    	   
    		 
    	 }
    	 
    	  
    	 */  
    	 
       
       