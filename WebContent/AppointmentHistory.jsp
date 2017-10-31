<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    

<%@ page import="java.util.List" %>
<%@ page import="com.main.egeia.models.Appointment" %>
<%@ page import="com.main.egeia.services.AppointmentService " %>
<%@ page import="com.main.egeia.utils.SessionUtils" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <meta charset="UTF-8">
   <link rel="shortcut icon" type="image/png" href="photos/egeialogo.png"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>e-geia</title>
  <link rel="stylesheet" href="css/deletedoc.css">
<body>
<body>

<h3>Here is your programmed appointments!!!</h3>
<form>
<div class="container">
  	<img src="photos/logo.png">
<table style="width:100%" bgcolor="#666666">
<tr>
    	<th>id</th>
    	<th>Day</th>
    	 <th>Month</th>
    	<th>Year</th>
    	<th>Time</th>
    </tr>
<%
int userId = SessionUtils.getSessionUserId(session);

AppointmentService service = new AppointmentService();
List<Appointment> appointments = service.GetAppointments(userId);
for(Appointment ap : appointments)
{
%>
	<tr>
  
    	<td><%= ap.getId() %></td>
    	<td><%= ap.getDay() %></td>
    	<td><%= ap.getMonth() %></td>
    	<td><%= ap.getYear() %></td>
    	<td><%= ap.getTime() %></td> 
    
    </tr>
<%
} 

%>
</table>
</form>

</body>
</html>