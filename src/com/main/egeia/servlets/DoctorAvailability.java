package com.main.egeia.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.main.egeia.models.Availability;
import com.main.egeia.models.UserType.Type;
import com.main.egeia.services.DocAvailabilityService;
import com.main.egeia.utils.SessionUtils;

/**
 * Servlet implementation class DoctorAvailability
 */
@WebServlet("/DoctorAvailability")
public class DoctorAvailability extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DocAvailabilityService service = new DocAvailabilityService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorAvailability() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		SessionUtils.checkTypePermission(request, response, Type.DOCTOR, "index.jsp");
		response.sendRedirect("DoctorAvailability.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int day= Integer.parseInt(request.getParameter("day"));             //pairnei apo thn forma tis times gia th diathesimothta
		int month= Integer.parseInt(request.getParameter("month"));
		int year= Integer.parseInt(request.getParameter("year"));
		String time = request.getParameter("time");
		String docname = request.getParameter("docname");
		HttpSession session = request.getSession();
		
		Availability avail = new Availability();
		avail.setDay(day);
		avail.setMonth(month);
		avail.setYear(year);
		avail.setTime(time);
		avail.setDoctorName(docname);
		avail.setDoctorId(SessionUtils.getSessionUserId(session));      //krataei to id tou giatrou
		
		int res = service.InsertAvailability(avail);   //kai kalei thmethodo insert.. tou service
		if( res >= 0 )                                 //an to res apo excecute update einai >0 tote exoun perastei ta dedomena
		{                                              //tote mhnuma epituxous insertion
			response.getWriter().append("Succesfully inserted availability: " + avail.getDay() + avail.getMonth() +avail.getYear() );
		} else 
		{
			response.getWriter().append("Error at inserting value. Please try again later.").append(request.getContextPath());
		}
		
		
	}

}
