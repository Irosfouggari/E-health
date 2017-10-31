<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="java.util.List" %>
<%@ page import="com.main.egeia.models.Availability" %>
<%@ page import="com.main.egeia.services.DocAvailabilityService" %>
<%@ page import="com.main.egeia.utils.SessionUtils" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>e-geia</title>
  <link rel="stylesheet" href="css/patdate.css">
</head>
<body>
<h3>E-geia Doctors availabilities!</h3>
<div class="container">
<form>

  	<img src="photos/logo.png">
    <table style="width:100%" bgcolor="#666666"> </div>
	<tr>
    	<th>Day</th>
    	<th>Month</th>
    	<th>Year</th> 
    	<th>Time</th>
    	<th>Name</th>
    </tr>
<%


DocAvailabilityService service = new DocAvailabilityService();
List<Availability> availabilities = service.GetAppointments();
for(Availability av : availabilities)
{
%>
	<tr>
    	<td><%= av.getDay() %></td>
    	<td><%= av.getMonth() %></td>
    	<td><%= av.getYear() %></td>
    	<td><%= av.getTime() %></td> 
    	<td><%= av.getDoctorName() %></td> 
    	<td class="setdate"><input type="button" value="Set Date"></td>
    
    </tr>
<%
} 
%>
</table>
<script src="js/jquery.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
$('.setdate').on('click', function(){
	
	var $that = $(this);
	var id = $that.prev().text(); 
	
	$.ajax({
		  method: "POST",
		  url: "/Egeia2017/PatDate",
		  data: { doctorId: id }
		}).done(function( msg ) {
		    alert( "Changes saved ");
		});
});

	
});
</script>
</form>
</body>
</html>