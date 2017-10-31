package com.main.egeia.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dbconnection.java.DbConnection;
import com.main.egeia.models.Doctor;

public class DoctorRepository {

	
	
	public boolean DeleteDoctor(int id)      //edw diagrafetai apo th bash o iatros me to sugkekrimeno id
	{
		boolean res = false;
		Connection conn = DbConnection.getMysqlConnection();
		String loginquery = "DELETE FROM Doctors WHERE id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(loginquery);
			pstmt.setInt(1, id);
			res = pstmt.executeUpdate() == 0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
		
	}
	
	
	public int InsertDoctor(Doctor doctor)   //pairnw to doctor apo to service
	{                                        //kai eisagw ton giatro sto table doctors
		
		int res = -1;
		String sql="insert into doctors(firstname,lastname,username,password,email,gender,speciality)values(?,?,?,?,?,?,?)";
		Connection con=DbConnection.getMysqlConnection();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, doctor.getFirstName());
			ps.setString(2, doctor.getLastName());
			ps.setString(3, doctor.getUsername());
			ps.setString(4, doctor.getPassword());
			ps.setString(5, doctor.getEmail());
			ps.setString(6, doctor.getGender());
			ps.setString(7, doctor.getSpeciality());
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;    //epistrefw res p an exei ginei epityxhs eggrafh tha einai >0
		
	}
	
	public List<Doctor> GetDoctors()    //edw pairnoume oles tis eggrafes iatrwn apo th bash
	{
		List<Doctor> doctors = new ArrayList<>();  //kai ta bazoume se lista
		
		String sql = "SELECT * FROM Doctors";
		Connection con=DbConnection.getMysqlConnection();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ResultSet result = ps.executeQuery();
			while(result.next())
			{
				Doctor doctor = new Doctor();
				doctor.setId(result.getInt("id"));
				doctor.setFirstName(result.getString("firstname"));
				doctor.setLastName(result.getString("lastname"));
				doctor.setSpeciality(result.getString("speciality"));
				doctor.setGender(result.getString("gender"));
				doctor.setEmail(result.getString("email"));
				doctor.setPassword(result.getString("password"));
				doctors.add(doctor);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return doctors;
	}
	
	public Doctor GetDoctor(int id)      //kanoume select ton giatro me to sugkekrimeno id 
	{
		Doctor doctor = null;
		
		String sql = "SELECT * FROM Doctors WHERE id = ?";
		Connection con=DbConnection.getMysqlConnection();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet result = ps.executeQuery();
			while(result.next())
			{
				doctor = new Doctor();
				doctor.setId(result.getInt("id"));
				doctor.setFirstName(result.getString("firstname"));
				doctor.setLastName(result.getString("lastname"));
				doctor.setSpeciality(result.getString("speciality"));
				doctor.setGender(result.getString("gender"));
				doctor.setEmail(result.getString("email"));
				doctor.setPassword(result.getString("password"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return doctor;
	}
	
	public Doctor Login(String username, String password)     //pairnoume apo to servise username kai password
	{
		Doctor doctor = null;
		
		String sql = "SELECT * FROM Doctors WHERE username = ? AND password = ?";  //kai pswxnoume ton xrhsth ston table doctors
		Connection con=DbConnection.getMysqlConnection();     //sundesh me th bash
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet result = ps.executeQuery();      //kai an upraxei sth bash kratame ta stoixeia tou gia parapanw
			while(result.next())                     //xrhsh
			{
				doctor = new Doctor();
				doctor.setId(result.getInt("id"));
				doctor.setFirstName(result.getString("firstname"));
				doctor.setLastName(result.getString("lastname"));
				doctor.setSpeciality(result.getString("speciality"));
				doctor.setGender(result.getString("gender"));
				doctor.setEmail(result.getString("email"));
				doctor.setPassword(result.getString("password"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return doctor;   //epistrefw doctor sto service
	}
}
