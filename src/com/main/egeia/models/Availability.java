package com.main.egeia.models;

public class Availability {
	
	private int Id;
	private int DoctorId;
	private int Day;
	private int Month;
	private int Year;
	private String Time;
	private String DoctorName;
	
	public Availability(int id,int doctorId, int day,int month,int year,String time,String docname)
	{
		super();
		Id = id;
		DoctorId = doctorId;
		Day=day;
		Month = month;
		Year =year;
		Time = time;
		DoctorName=docname;
	
	}

	public String getDoctorName() {
		return DoctorName;
	}

	public void setDoctorName(String doctorName) {
		DoctorName = doctorName;
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

	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	
	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		Time = time;
	}
	public Availability() {
		// TODO Auto-generated constructor stub
	}
	public int getDoctorId() {
		return DoctorId;
	}
	public void setDoctorId(int doctorId) {
		this.DoctorId = doctorId;
	}
	
	

}
