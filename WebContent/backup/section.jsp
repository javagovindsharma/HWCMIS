<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dashboard</title>
   <link href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css"/>
 
 <!-- Bootstrap core CSS-->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom fonts for this template-->
<link href="vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<!-- Page level plugin CSS-->
 <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
<!-- Custom styles for this template-->
<link href="css/sb-admin.css" rel="stylesheet">




</head>
<body  onload="javascript:loadTable()">
	
	<jsp:include page="header.jsp"></jsp:include>

	<!-- --home body -->
	<div class="content-wrapper" style="    margin-left: 40px;">
		<div class="container-fluid">
			

			<!-- Example DataTables Card-->
			<div class="card mb-3">
				<div class="card-header">
					<i class="fa fa-table"></i> Approve Status
				</div>
				<div class="card-body"> 
					<div class="table-responsive">
						 <table class="table table-bordered" id="dataTable" width="100%"  cellspacing="0"   >
							<thead>
								<tr>
									<th>Email ID </th>
									<th>Approval Status </th>
									<th>User Type</th>
									<th>Mobile Number</th>
									<th>User Name</th>
									<th >Action</th>
								</tr>
							</thead>
							
							<tbody >
								
							</tbody>
						</table> 
						
						
						
					</div>
				</div>
				
							
				<div class="card-footer small text-muted">Updated yesterday at
					</div>
			</div>
		</div>
		
	</div>
  
	<!-- ---------close  -->
</body>
</html>