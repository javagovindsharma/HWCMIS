//<!-- ----Page loading time call jquery and source and target data filled---------- -->

$(document).ready(function(){
	district();
	service();
	subservice();
	referalTableLoad();
});

/*
function startreferal() {
	subcenter();
	service();
	subservice();
	referalTableLoad();
}*/


function district() {
	
	
	$("#id_district").get(0).options.length = 0;
	$("#id_district").get(0).options[0] = new Option("Loading names", "-1");
	
	$.ajax({
		type : "post",
		url : "referal?method=getDistrict",
		data : {},
		contentType : "application/json; charset=utf-8",
		dataType : 'json',
		cache : false,
		success : function(msg) {

			$("#id_district").get(0).options.length = 0;
			$("#id_district").get(0).options[0] = new Option("--Select--","-1");

			$.each(msg.fill,
					function(index, item) {
						$("#id_district").get(0).options[$("#id_district")
								.get(0).options.length] = new Option(
								item.SourceValue, item.SourceName);
					});
		},
		error : function() {
			$("#id_district").get(0).options.length = 0;

		}
	});
}

function block() {
	
	var id_district = $("#id_district").val();
	$("#id_subcenter").get(0).options.length = 0;
	$("#id_subcenter").get(0).options[0] = new Option("Loading names", "-1");

	var data = {
			id_district : id_district
	};
	$.ajax({
		type : "post",
		url : "referal?method=getBlock",
		data : JSON.stringify(data),
		contentType : "application/json; charset=utf-8",
		dataType : 'json',
		cache : false,
		success : function(msg) {

			$("#id_block").get(0).options.length = 0;
			$("#id_block").get(0).options[0] = new Option("--Select--","-1");

			$.each(msg.fill,
					function(index, item) {
						$("#id_block").get(0).options[$("#id_block")
								.get(0).options.length] = new Option(
								item.SourceValue, item.SourceName);
					});
		},
		error : function() {
			$("#id_block").get(0).options.length = 0;

		}
	});
}

function subcenter() {
	
	var id_block = $("#id_block").val();
	$("#id_subcenter").get(0).options.length = 0;
	$("#id_subcenter").get(0).options[0] = new Option("Loading names", "-1");

	var data = {
			id_block : id_block
	};
	$.ajax({
		type : "post",
		url : "referal?method=getSubcenter",
		data : JSON.stringify(data),
		contentType : "application/json; charset=utf-8",
		dataType : 'json',
		cache : false,
		success : function(msg) {

			$("#id_subcenter").get(0).options.length = 0;
			$("#id_subcenter").get(0).options[0] = new Option("--Select--","-1");

			$.each(msg.fill,
					function(index, item) {
						$("#id_subcenter").get(0).options[$("#id_subcenter")
								.get(0).options.length] = new Option(
								item.SourceValue, item.SourceName);
					});
		},
		error : function() {
			$("#id_subcenter").get(0).options.length = 0;

		}
	});
}

function service() {

	$("#servicesCell").get(0).options.length = 0;
	$("#servicesCell").get(0).options[0] = new Option("Loading names", "-1");

	$.ajax({
		type : "post",
		url : "Question?method=setService",
		data : {},
		contentType : "application/json; charset=utf-8",
		dataType : 'json',
		cache : false,
		success : function(msg) {

			$("#servicesCell").get(0).options.length = 0;
			 $("#servicesCell").get(0).options[0] = new Option("--Select--", "-1");

			$.each(msg.fill,
					function(index, item) {
						$("#servicesCell").get(0).options[$("#servicesCell")
								.get(0).options.length] = new Option(
								item.SourceValue, item.SourceName);
					});

		},
		error : function() {
			$("#servicesCell").get(0).options.length = 0;

		}
	});

}

function subservice() {

	$("#subServices").get(0).options.length = 0;
	$("#subServices").get(0).options[0] = new Option("Loading names", "-1");

	$.ajax({
		type : "post",
		url : "Question?method=setSubService",
		data : {},
		contentType : "application/json; charset=utf-8",
		dataType : 'json',
		cache : false,
		success : function(msg) {

			$("#subServices").get(0).options.length = 0;
			$("#subServices").get(0).options[0] = new Option("--Select--", "-1");

			$.each(msg.fill,
					function(index, item) {
						$("#subServices").get(0).options[$("#subServices").get(0).options.length] = new Option(item.SourceValue, item.SourceName);
					});

		},
		error : function() {
			$("#subServices").get(0).options.length = 0;

		}
	});

}

function getVillage() {

	var subcenter = $("#id_subcenter").val();
	$("#id_village").get(0).options.length = 0;
	$("#id_village").get(0).options[0] = new Option("Loading names", "-1");

	var data = {
		subcenter : subcenter
	};
	$.ajax({
				type : "post",
				url : "referal?method=getVillage",
				data : JSON.stringify(data),
				contentType : "application/json; charset=utf-8",
				dataType : 'json',
				cache : false,
				success : function(msg) {

					$("#id_village").get(0).options.length = 0;
					$("#id_village").get(0).options[0] = new Option(
							"--Select--", "-1");

					$
							.each(
									msg.fill,
									function(index, item) {
										$("#id_village").get(0).options[$(
												"#id_village").get(0).options.length] = new Option(
												item.SourceValue,
												item.SourceName);
									});

				},
				error : function() {
					$("#id_village").get(0).options.length = 0;

				}
			});

}

function getAsha() {

	var village = $("#id_village").val();


	$("#id_asha").get(0).options.length = 0;
	$("#id_asha").get(0).options[0] = new Option("Loading names", "-1");

	var data = {
		village : village
	};
	$.ajax({
		type : "post",
		url : "referal?method=getAsha",
		data : JSON.stringify(data),
		contentType : "application/json; charset=utf-8",
		dataType : 'json',
		cache : false,
		success : function(msg) {

			$("#id_asha").get(0).options.length = 0;
			$("#id_asha").get(0).options[0] = new Option("--Select--", "-1");

			$
					.each(msg.fill,
							function(index, item) {
								$("#id_asha").get(0).options[$("#id_asha").get(
										0).options.length] = new Option(
										item.SourceValue, item.SourceName);
							});

		},
		error : function() {
			$("#id_asha").get(0).options.length = 0;

		}
	});

}

// use for only Enter Numeric value
function isNumber(evt) {
	evt = (evt) ? evt : window.event;
	var charCode = (evt.which) ? evt.which : evt.keyCode;
	if (charCode > 31 && (charCode < 48 || charCode > 57)) {
		return false;
	}
	return true;
}








   //here code for referal table data

    function searchReferal(){

    	var id_subcenter = $("#id_subcenter").val();
    	var id_village = $("#id_village").val();
    	var id_asha = $("#id_asha").val();
    	var servicesCell = $("#servicesCell").val();
    	var subServices = $("#subServices").val();
    	var id_form_date = $("#id_form_date").val();
    	var id_to_date = $("#id_to_date").val();
    	
    	var data={
    			id_subcenter:id_subcenter,
    			id_village:id_village,
    			id_asha:id_asha,
    			servicesCell:servicesCell,
    			subServices:subServices,
    			id_form_date:id_form_date,
    			id_to_date:id_to_date
    	}
    	$.ajax({
    			   type:"post",
    			   url : "referal?method=getReferalSearchData",
    			   contentType: "application/json", 
    			   data: JSON.stringify(data),
    			   cache: false,
    	  	 success : function(data2) {
    	  		
    	  		 
    	  		var strData= JSON.parse(data2);
    	  		 var data=strData['data'];
    	  		$("#tbl_div").empty();
    	  		
    	  		var table="<table id='example' class='table table-striped table-bordered' style='font-size: 12px;'>";
    	  		table+="<thead><tr> <th>Patient ID</th><th>Patient Name</th><th>Service</th><th>Sub-Service</th><th>Village</th>";
    	  		table+="<th>Referred Date</th><th>Status</th><th>Status UpdateDate</th><th>Refered By</th>";
    	  		table+="</tr></thead><tbody  id='tbl_body'>";
    	  		
    	  		 var tr="";
    	  			for(var k=0;k<data.length();k++){
    	  				 tr+="<tr>";
    					   tr=tr + "<td >"+data[k].households_member_unique_id+"</td>" ;
    	  				   tr=tr + "<td >"+data[k].person_name+"</td>" ;
    					   tr=tr + "<td >"+data[k].village_name+"</td>" ;
    					   tr=tr + "<td >"+data[k].name_of_asha+"</td>" ;
    					   tr=tr + "<td >"+data[k].refered_date+"</td>" ;
    					   tr=tr + "<td >"+data[k].service_name+"</td>" ;
    					   tr=tr + "<td >"+data[k].subservices_name+"</td>" ;
    					   tr=tr + "<td >"+data[k].status_updated+"</td>" ;
    					   tr=tr + "<td >"+data[k].referal_by+"</td>" ;
    					   tr=tr+"</tr>";
    				  
    				  
    	  			}//for loop
    	  			
    	  			table+=tr;
    	  			table+="</tbody></table>";
    		  		
    		  		
    		  		$('#tbl_div').html(table);
    		  		$('#tbl_div table').attr('id','example');
    	  			var table = $('#example').DataTable( {
    	  				 lengthChange: true,destroy:true,
    	  	  		      scrollX: true,// scrollY: true, "sScrollY": ($(window).height() - 300),
    	  	  		          buttons: [ 'copy', 'excel', 'pdf', 'colvis' ]
    	  	  		        } );

    				    table.buttons().container()
    				        .appendTo('#example_wrapper .col-sm-6:eq(0)');
    				    
    				    referalTableLoad
    	  		
    			},
    			error : function(data2) {
    				$('#example').empty();
    				alert("Failed");
    			}
    		})
    	
    	
    }	





     function referalTableLoad(){
    	 $.ajax({
			   type:"post",
			   url : "referal?method=getReferalData",
			   contentType: "application/json", 
			   cache: false,
	  	 success : function(data2) {
	  		
	  		 console.log(data2);
	  		 var strData= JSON.parse(data2);
	  		 var data=strData['DATA'];
	  		 
	  		$("#tbl_div").empty();
	  		
	  		var table="<table id='example' class='table table-striped table-bordered' style='width:100%'>";
	  		table+="<thead><tr> <th>Patient ID</th><th>Patient Name</th><th>Service</th><th>Sub-Service</th><th>Village</th>";
	  		table+="<th>Referred Date</th><th>Status</th><th>Status UpdateDate</th><th>Refered By</th>";
	  		table+="</tr></thead><tbody  id='tbl_body'>";
	  		
	  		var tr="";
	  			for(var k=0;k<data.length;k++){
	  				
	  				 tr+="<tr>";
					   tr=tr + "<td >"+data[k].households_member_unique_id+"</td>" ;
	  				   tr=tr + "<td >"+data[k].person_name+"</td>" ;
					   tr=tr + "<td >"+data[k].village_name+"</td>" ;
					   tr=tr + "<td >"+data[k].name_of_asha+"</td>" ;
					   tr=tr + "<td >"+data[k].refered_date+"</td>" ;
					   tr=tr + "<td >"+data[k].service_name+"</td>" ;
					   tr=tr + "<td >"+data[k].subservices_name+"</td>" ;
					   tr=tr + "<td >"+data[k].status_updated+"</td>" ;
					   tr=tr + "<td >"+data[k].referal_by+"</td>" ;
					   tr=tr+"</tr>";
				  
				  
	  			}//for loop
	  			
	  			table+=tr;
	  			table+="</tbody></table>";
		  		
		  		
		  		$('#tbl_div').html(table);
		  		
	  			var table = $('#example').DataTable( {
	  				 lengthChange: true,destroy:true,
	  	  		      scrollX: true,// scrollY: true, "sScrollY": ($(window).height() - 300),
	  	  		          buttons: [ 'copy', 'excel', 'pdf' ]
	  	  		        } );

				    table.buttons().container()
				        .appendTo('#example_wrapper .col-sm-6:eq(0)');
				    
				   
	  		
			},
			error : function(data2) {
				$('#example').empty();
				alert("Failed");
			}
		})
     }

















