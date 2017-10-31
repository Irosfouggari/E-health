package com.main.egeia.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dbconnection.java.DbConnection;
import com.main.egeia.models.Doctor;
import com.main.egeia.models.Patient;

public class PatientRepository {
	
	public int InsertPatient(Patient patient)
	{     
		//sto repository ginetai h eisagwgh sth bash to opoio allhlepidra me to service
		//afou exoun ginei oi aparaithtoi elegxoi sundeomaste me th bash kai to syglekrimeno table
		//kai eisagoume ta dedomena
		
		int res = -1;              //thetoume thn metablhth res = -1
		String sql="insert into patients(firstname,lastname,username,password,email,gender,amka,age)values(?,?,?,?,?,?,?,?)";
		Connection con=DbConnection.getMysqlConnection();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, patient.getFirstName());
			ps.setString(2, patient.getLastName());
			ps.setString(3, patient.getUsername());
			ps.setString(4, patient.getPassword());
			ps.setString(5, patient.getEmail());
			ps.setString(6, patient.getGender());
			ps.setString(7, patient.getAmka());
			ps.setInt(8,patient.getAge());  
			res = ps.executeUpdate();         //kai an exei ginei epituxws to insertion tote to res tha einai > -1
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;    //epistrefoyme sto servlet thn timh tou res
		
	}
	
	public Patient Login(String username, String password)     //
	{
		Patient patient = null;
		
		String sql = "SELECT * FROM patients WHERE username = ? AND password = ?";
		Connection con=DbConnection.getMysqlConnection();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);                   
			ResultSet result = ps.executeQuery();
			while(result.next())
			{ 
				patient = new Patient();                     //pairnw ta dedomena gia to sugkekrimeno xrhsth
				patient.setId(result.getInt("id")); 
				patient.setFirstName(result.getString("firstname"));
				patient.setLastName(result.getString("lastname"));
				patient.setGender(result.getString("gender"));
				patient.setEmail(result.getString("email"));
				patient.setAmka(result.getString("amka"));
				patient.setAge(result.getInt("age"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return patient;
	}
	
	public Patient GetPatient(int id)
	{
		Patient patient = null;
		
		String sql = "SELECT * FROM patients WHERE id = ?";
		Connection con=DbConnection.getMysqlConnection();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet result = ps.executeQuery();
			while(result.next())
			{
				patient = new Patient();
				patient.setId(result.getInt("id"));
				patient.setFirstName(result.getString("firstname"));
				patient.setLastName(result.getString("lastname"));
				patient.setGender(result.getString("gender"));
				patient.setEmail(result.getString("email"));
				patient.setPassword(result.getString("password"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return patient;
	}

}
