<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    

<%@ page import="java.util.List" %>
<%@ page import="com.main.egeia.models.Availability" %>
<%@ page import="com.main.egeia.services.DocAvailabilityService" %>
<%@ page import="com.main.egeia.utils.SessionUtils" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <meta charset="UTF-8">
   <link rel="shortcut icon" type="image/png" href="photos/egeialogo.png"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>e-geia</title>
  <link rel="stylesheet" href="css/deletedoc.css">
<body>

<h4>Here's your schedule!!</h4>
<div class="container">
<form>

  	<img src="photos/logo.png">
<table style="width:100%" bgcolor="#666666">
	<tr>
    	<th>Day</th>
    	<th>Month</th>
    	<th>Year</th> 
    	<th>Time</th>
    </tr>
<%
int userId = SessionUtils.getSessionUserId(session);   //kalw thn getSessionUserId tou session utils

DocAvailabilityService service = new DocAvailabilityService();  //parei to id
List<Availability> availabilities = service.GetAppointments(userId);
for(Availability av : availabilities)
{
%>
	<tr>
    	<td><%= av.getDay() %></td>
    	<td><%= av.getMonth() %></td>
    	<td><%= av.getYear() %></td>
    	<td><%= av.getTime() %></td> 
    
    </tr>
<%
} 
%>
</table>
</form>

</body>
</html>