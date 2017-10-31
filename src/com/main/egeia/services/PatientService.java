package com.main.egeia.services;

import java.util.List;

import com.main.egeia.models.Doctor;
import com.main.egeia.models.Patient;
import com.main.egeia.repositories.DoctorRepository;
import com.main.egeia.repositories.PatientRepository;
import com.main.egeia.utils.PasswordEncoder;

public class PatientService {
	
private PatientRepository repo = new PatientRepository();
	

	
	public int InsertPatient(Patient patient)
	{
		int res = -1;
		if( patient.getFirstName().isEmpty() ||      //meta to servlet erxomaste edw opou ginontai oi aparaithtoi elegxoi 
				patient.getLastName().isEmpty() ||   //gia adeies sumboloseores , password confirmation klp
				patient.getEmail().isEmpty() || 
				patient.getGender().isEmpty() ||
				patient.getPassword().isEmpty() ||
				patient.getCPassword().isEmpty() ||
				patient.getUsername().isEmpty() ||
				patient.getAge()>100 ||
				patient.getAmka().isEmpty() || patient.getAmka().length()>11 ||
				!(patient.getPassword()).equals(patient.getCPassword())
				
		  )
			return res;

		if( patient.getPassword().length() < 64)    //kathws kai hashing ston kwdiko   
			//Need to hash password - Dummy check      //ef oson ola einai ok phgainoume sto repository
			patient.setPassword(PasswordEncoder.encode(patient.getPassword()));   //gia na ginei h eisagwgh sth bash
		   
		return repo.InsertPatient(patient);
	}
	
	
	public Patient Login(String username, String password)
	{
		Patient pat = null;                     //elegxos an einai kena ta insertion tou xrhsth
		if( username.isEmpty() || password.isEmpty() ) return pat;
		//Needs to hash it
		String hashed_pass = PasswordEncoder.encode(password); //kai elegxos gia hash
		pat = repo.Login(username, hashed_pass);     //paw sto repository gia na brw ton xrhsth sth bash
		return pat;
	}
	

	
	public Patient GetPatient(int id)     
	{
		Patient pat = null;
		if (id > 0 ) return pat;
		pat = repo.GetPatient(id);
		return pat;
	}

}
