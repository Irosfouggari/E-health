package com.main.egeia.models;

public class Appointment {
	
	private int Id;
	private int DoctorId;
	private int PatientId;
	private int Day;
	private int Month;
	private int Year;
	private String Time;
	
	
	public Appointment(int id,int doctorId,int patientId, int day, int month,int year, String time)
	{
		super();
		Id = id;
		DoctorId = doctorId;
		PatientId=patientId;
		Day = day;
	    Month = month;
	    Year = year;
	    Time = time;
	    
	    
	
	}


	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getTime() {
		return Time;
	}


	public void setTime(String time) {
		Time = time;
	}


	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public int getDoctorId() {
		return DoctorId;
	}


	public void setDoctorId(int doctorId) {
		DoctorId = doctorId;
	}


	public int getPatientId() {
		return PatientId;
	}


	public void setPatientId(int patientId) {
		PatientId = patientId;
	}


	public int getDay() {
		return Day;
	}


	public void setDay(int day) {
		Day = day;
	}


	public int getMonth() {
		return Month;
	}


	public void setMonth(int month) {
		Month = month;
	}


	public int getYear() {
		return Year;
	}


	public void setYear(int year) {
		Year = year;
	}


	
}
