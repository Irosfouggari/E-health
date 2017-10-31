<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.List" %>
<%@ page import="com.main.egeia.models.Doctor" %>
<%@ page import="com.main.egeia.services.DoctorService" %>
<%@ page import="com.main.egeia.utils.SessionUtils" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
   <link rel="shortcut icon" type="image/png" href="photos/egeialogo.png"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>e-geia</title>
 <link rel="stylesheet" href="css/doclist.css">
</head>
<body> 
<h3>Doctors of e-geia are here for your health!!</h3>    
<div class="container">
<form>

  	<img src="photos/logo.png">
     <form  action="DoctorAvailability" method="post">
     <table style="width:100%" bgcolor="#666666">
	<tr>
    	<th>Id</th>
    	<th>Name</th>
    	<th>Speciality</th> 
    </tr>
<%
DoctorService service = new DoctorService();     //kaloume th lista twn iatrwn apo to repository kai 
List<Doctor> doctors = service.GetDoctors();      //tis emfanizw
for(Doctor doc : doctors){
%>
<tr>
<td><%= doc.getId() %></td>
<td><%= doc.getFirstName() %> <%= doc.getLastName() %></td>
<td><%= doc.getSpeciality() %></td>
  </tr>
<%
} 
%>
</table>
</form>
</div>
</body>
</html>