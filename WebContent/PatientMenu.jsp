<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="UTF-8">
   <link rel="shortcut icon" type="image/png" href="photos/egeialogo.png"/>
   <title>Welcome to E-geia</title>
     <link rel="stylesheet" href="css/patmenu.css">
  </head>

  <body>
  
<h3>Welcome Patient!!!</h3>
  
<div class="container">
  	<img src="photos/logo.png">
  	<ul>
    <p  style="color:#800000;" Tstyle="text-align:center"><font size="7"> Menu</font></p>
  <li>   
  <p style="text-align:center"><font size="4"><a href="AppointmentHistory.jsp" STYLE="text-decoration: none;  color:#0f0f0a;">Appointment History</a> 
  <p style="text-align:center"><font size="4"><a href="DoctorList.jsp" STYLE="text-decoration: none;  color:#0f0f0a;">E-geia Doctors</a>  </li> 
	 <li><p style="text-align:center"><font size="4"><a href="PatientDate.jsp" STYLE="text-decoration: none;  color:#0f0f0a;">Set an Appointment</a></li>
	<li> <p style="text-align:center"><font size="4"><a href="CancelAppointmentByPatient.jsp" STYLE="text-decoration: none;  color:#0f0f0a;">Cancel Appointment</a></li>
 </ul>
 </div>
 <a href="Logout.jsp" STYLE="text-decoration: none;  color:#ffffff">Log out</a>
  <script>
   window.location.hash="no-back-button";
   window.location.hash="Again-No-back-button";//again because google chrome don't insert first hash into history
   window.onhashchange=function(){window.location.hash="no-back-button";}
</script> 
  </body>
</html>