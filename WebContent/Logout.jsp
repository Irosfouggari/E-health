<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="UTF-8">
   <link rel="shortcut icon" type="image/png" href="photos/egeialogo.png"/>
   <title>Welcome to E-geia</title>
     <link rel="stylesheet" href="css/logout.css">
  </head>
  <br>
  <br>
<div class="container">
<img src="photos/logo.png">
<p style="color:black;" style="font-size:160%;">Are you sure you want to logout??</p>

  <body>
  <form action="${pageContext.request.contextPath}/logout" method="post">
    <input type="submit" value="Logout" />
  </form></div>
 
    </body>
</html>