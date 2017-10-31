package com.main.egeia.services;

import java.util.List;

import com.main.egeia.models.Doctor;
import com.main.egeia.repositories.DoctorRepository;
import com.main.egeia.utils.PasswordEncoder;

public class DoctorService {

	private DoctorRepository repo = new DoctorRepository();
	
	public boolean DeleteDoctor(int id)
	{
		boolean res = false;        //kanw elegxo an uparxei ontws krathmeno id kai kalw Doctoreposiry
		if( id < 0 ) 
			return res;
		
		return repo.DeleteDoctor(id);
	}
	
	public int InsertDoctor(Doctor doctor)    //pairnoume apo to servlet ton doctor(name,surname,.....)
	{
		int res = -1;
		if( doctor.getFirstName().isEmpty() ||    //kanoume elegxo gia kenes times
			doctor.getLastName().isEmpty() ||
			doctor.getEmail().isEmpty() || 
			doctor.getSpeciality().isEmpty() ||
			doctor.getGender().isEmpty() ||
			doctor.getPassword().isEmpty() ||
			!(doctor.getPassword()).equals(doctor.getCPassword())
		  )
			return res;
		
		if( doctor.getPassword().length() < 64)         //kanw hash to password
			//Need to hash password - Dummy check
			doctor.setPassword(PasswordEncoder.encode(doctor.getPassword()));
		return repo.InsertDoctor(doctor);    //kai kalw thn insertDoctor tou repository
	}
	
	public List<Doctor> GetDoctors()   
	{
		return repo.GetDoctors();
	}
	
	public Doctor GetDoctor(int id)     //edw kratame sugkekrimeno giatro 
	{
		Doctor doc = null;
		if (id > 0 ) return doc;
		doc = repo.GetDoctor(id);
		return doc;
	}
	
	public Doctor Login(String username, String password)      //pairnoyme tis times apo to servlet
	{
		Doctor doc = null;
		if( username.isEmpty() || password.isEmpty() ) return doc;  //kanoume elegxo gia kenes times
		//Needs to hash it
		String hashed_pass = PasswordEncoder.encode(password);   //tesekaroume hashed password
		doc = repo.Login(username, hashed_pass);   //kai an ola einai kala pame sth methodo log in tou reposirtory
		return doc;                               //epistrefw doc sto servlet
	}
}
