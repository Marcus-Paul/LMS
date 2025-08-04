package com.lms.Auth;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lms.DB_Connection.DBConnection;

public class AuthService {
	public static ResultSet login(String email, String password) {
		try {
			Connection connection = DBConnection.getConnection();
			String query = "select * from users where email = ?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			
			return rs;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ResultSet accessCheck(int id) {
		try {
			Connection connection = DBConnection.getConnection();
			String query = "select * from user_role where user_id = ?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			 return rs;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
