package com.main.egeia.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbconnection.java.DbConnection;
import com.main.egeia.models.Doctor;
import com.main.egeia.services.DoctorService;

/**
 * Servlet implementation class DoctorRegistration
 */
@WebServlet("/DoctorRegistration")
public class DoctorRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String fn= request.getParameter("fname");    //pairnoume ta dedomena apo th forma
		String ln= request.getParameter("lname");
		String un= request.getParameter("uname");
		String pass= request.getParameter("password");
		String cpass=request.getParameter("cpassword");
		String email= request.getParameter("email");
		String gender= request.getParameter("gender");
		String specialty= request.getParameter("Speciality");
		
		Doctor doctor = new Doctor(0,fn,ln,un,pass,cpass,email,specialty,gender);
		DoctorService service = new DoctorService();     //apo edw phgainpume sto service gia tous aparaithtous elegxous
		int res = service.InsertDoctor(doctor);         //apo to repository pairnoume apanthsh to res kai an einai > -1 o userexei eggrafei epituxws sto susthma
		
		if( res > -1 )   //an exei ginei epituxhs eggrafh tha exoume res >-1
			response.getWriter().append("Succesfully inserted doctor with id : " + doctor.getFirstName());
		else
			response.getWriter().append("Unuccesfully inserted doctor with");
	}

}
