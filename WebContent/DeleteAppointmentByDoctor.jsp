<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.main.egeia.utils.SessionUtils" %>
<%@ page import="java.util.List" %>
<%@ page import="com.main.egeia.models.Availability" %>
<%@ page import="com.main.egeia.services.DocAvailabilityService" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <meta charset="UTF-8">
   <link rel="shortcut icon" type="image/png" href="photos/egeialogo.png"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>e-geia</title>
  <link rel="stylesheet" href="css/deletedoc.css">
<body>
<body>

<h4>You can delete an hour of your schedule!!</h4>
<form>
<div class="container">
  	<img src="photos/logo.png">
<table style="width:100%" bgcolor="#666666">
	<tr>
    	<th>Day</th>
    	<th>Month</th> 
    	<th>Year</th>
    	<th>Time</th>
    	<th>ID</th>
    </tr>
<%
int userId = SessionUtils.getSessionUserId(session);   //ksekinaw kratwntas to id

DocAvailabilityService service = new DocAvailabilityService();
List<Availability> availabilities = service.GetAppointments(userId);
for(Availability av : availabilities)
{
%>
	<tr>
    	<td><%= av.getDay() %></td>
    	<td><%= av.getMonth() %></td>
    	<td><%= av.getYear() %></td>
    	<td><%= av.getTime() %></td> 
    	<td><%= av.getId() %></td>
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
		  method: "POST",                     //kalw servlet
		  url: "/Egeia2017/delap",
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