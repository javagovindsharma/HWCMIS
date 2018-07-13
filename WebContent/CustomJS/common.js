 //<!-- ----Page loading time call jquery and source and target data filled---------- -->
        
	   function Section() {
	    
	         $("#id_section").get(0).options.length = 0;
	         $("#id_section").get(0).options[0] = new Option("Loading names", "-1");
	     
	   
		     $.ajax({
		         type: "post",
			     url: "Question?method=setSection",
			     data: {} ,
			     contentType: "application/json; charset=utf-8",
			     dataType: 'json',
			     cache:false,
			     success: function(msg) {
			        
			         $("#id_section").get(0).options.length = 0;
			         $("#id_section").get(0).options[0] = new Option("--Select--", "-1"); 
			         
			         
			          $.each(msg.fill, function(index, item) {
			             $("#id_section").get(0).options[$("#id_section").get(0).options.length] = new Option(item.SourceValue, item.SourceName);
			         });
			     },
			     error: function() {
			         $("#id_section").get(0).options.length = 0;
			             
			         }
			     });
	} 

           
                       
                       
   function service() {
        
       $("#servicesCell").get(0).options.length = 0;
       $("#servicesCell").get(0).options[0] = new Option("Loading names", "-1");
       
     
       $.ajax({
           type: "post",
           url: "Question?method=setService",
           data: {} ,
           contentType: "application/json; charset=utf-8",
           dataType: 'json',
           cache:false,
           success: function(msg) {
              
               $("#servicesCell").get(0).options.length = 0;
       //        $("#servicesCell").get(0).options[0] = new Option("--Select--", "-1"); 
               
               
                $.each(msg.fill, function(index, item) {
                   $("#servicesCell").get(0).options[$("#servicesCell").get(0).options.length] = new Option(item.SourceValue, item.SourceName);
               });
               
               
           },
           error: function() {
               $("#servicesCell").get(0).options.length = 0;
               
           }
       });
    
  } 

   
   function subservice() {
       
       $("#subServices").get(0).options.length = 0;
       $("#subServices").get(0).options[0] = new Option("Loading names", "-1");
       
     
       $.ajax({
           type: "post",
           url: "Question?method=setSubService",
           data: {} ,
           contentType: "application/json; charset=utf-8",
           dataType: 'json',
           cache:false,
           success: function(msg) {
              
               $("#subServices").get(0).options.length = 0;
             //  $("#subServices").get(0).options[0] = new Option("--Select--", "-1"); 
               
               
                $.each(msg.fill, function(index, item) {
                   $("#subServices").get(0).options[$("#subServices").get(0).options.length] = new Option(item.SourceValue, item.SourceName);
               });
               
               
           },
           error: function() {
               $("#subServices").get(0).options.length = 0;
               
           }
       });
    
  } 

                
function setQuestion() {
       
       $("#id_questiontype").get(0).options.length = 0;
       $("#id_questiontype").get(0).options[0] = new Option("Loading names", "-1");
       
     
       $.ajax({
           type: "post",
           url: "Question?method=setQuestion",
           data: {} ,
           contentType: "application/json; charset=utf-8",
           dataType: 'json',
           cache:false,
           success: function(msg) {
              
               $("#id_questiontype").get(0).options.length = 0;
               $("#id_questiontype").get(0).options[0] = new Option("--Select--", "-1"); 
               
               
                $.each(msg.fill, function(index, item) {
                   $("#id_questiontype").get(0).options[$("#id_questiontype").get(0).options.length] = new Option(item.SourceValue, item.SourceName);
               });
               
               
           },
           error: function() {
               $("#id_questiontype").get(0).options.length = 0;
               
           }
       });
    
  } 

                  
                    
                     
                 

//use for only Enter Numeric value
function isNumber(evt) {
    evt = (evt) ? evt : window.event;
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
        return false;
    }
    return true;
}
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
 