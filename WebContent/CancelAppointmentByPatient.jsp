<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.main.egeia.utils.SessionUtils" %>
<%@ page import="java.util.List" %>
<%@ page import="com.main.egeia.models.Appointment" %>
<%@ page import="com.main.egeia.services.AppointmentService" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <meta charset="UTF-8">
   <link rel="shortcut icon" type="image/png" href="photos/egeialogo.png"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>e-geia</title>
  <link rel="stylesheet" href="css/deletedoc.css">
<body>
<body>

<h4>Here you can cancel a programmed appointment!!!</h4>
<form>
<div class="container">
  	<img src="photos/logo.png">
<table style="width:100%" bgcolor="#666666">
	<tr>
    	<th>Day</th>
    	<th>Month</th> 
    	<th>Year</th>
    	<th>Time</th>
    </tr>
<%
int userId = SessionUtils.getSessionUserId(session);

AppointmentService service = new AppointmentService();
List<Appointment> appointments = service.GetAppointments(userId);
for(Appointment apo : appointments)
{
%>
	<tr>
    	<td><%= apo.getDay() %></td>
    	<td><%= apo.getMonth() %></td> 
    	<td><%= apo.getYear() %></td>
    	<td><%= apo.getTime() %></td> 
    	<td class="appId"><input type="button" value="Delete"></td>
    </tr>
<%
} 
%>
</table>
<script src="js/jquery.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
$('.appId').on('click', function(){
	
	var $that = $(this);
	var id = $that.prev().text(); 
	
	$.ajax({
		  method: "POST",
		  url: "/Egeia2017/canap",
		  data: {appId: id }
		}).done(function( msg ) {
		    alert( "Data Saved!! ");
		});
});

	
});
</script> </div>
</form>

</body>
</html>