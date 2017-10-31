package com.main.egeia.services;

import java.util.Calendar;
import java.util.List;

import com.main.egeia.models.Availability;
import com.main.egeia.models.Doctor;
import com.main.egeia.repositories.DocAvailabilityRepository;
import com.main.egeia.repositories.DoctorRepository;

public class DocAvailabilityService {
	
private DocAvailabilityRepository repo = new DocAvailabilityRepository();
Calendar cal = Calendar.getInstance();
int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);

   public boolean DeleteAppointment(int id)    //tsekarw aplws an exei uparxei timh tou id
   {
 	boolean res = false;
	if( id < 0  )
		
		return res;
	
	 return repo.DeleteAppointment(id);       //kalei to repository kai afou tou epistrepsei timh thn stelnei sto servlet
   }

	
 /*	public int InsertDoctor(Doctor doctor)
	{
		int res = -1;
		if( doctor.getFirstName().isEmpty() || 
			doctor.getLastName().isEmpty() ||
			doctor.getEmail().isEmpty() || 
			doctor.getSpeciality().isEmpty() ||
			doctor.getGender().isEmpty() ||
			doctor.getPassword().isEmpty() 
		  )
			return res;
		
		return repo.InsertDoctor(doctor);
	}  */
	
	public int InsertAvailability(Availability availability)   //pairnei to availability apo to servlet
	{
		int res = -1;
		if( availability == null) return res;
		res = repo.InsertAvailability(availability);  //kai kalei thn InsertAvailability tou repository
		return res;            //epistrofh res sto servlet
	}
	public List<Availability> GetAppointments()
	{
		return repo.GetAppointments();
	}  
	
	public List<Availability> GetAppointments(int doctorId)
	{
		List<Availability> availabilities = null;
		if(doctorId < 0) return availabilities;
		availabilities = repo.GetAppointments(doctorId);
		return availabilities;
	}

}
