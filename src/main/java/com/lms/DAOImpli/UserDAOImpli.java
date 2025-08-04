package com.lms.DAOImpli;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lms.DAO.UserDAO;
import com.lms.TableClassess.Users;

public class UserDAOImpli implements UserDAO {
	
	private final Connection connection;
	
	public UserDAOImpli(Connection connection) {
		this.connection = connection;
	}

	
	public void createUser(Users users) {
		try {
			
			String query = "insert into users (email, password, membership_id, enabled) values (?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, users.getEmail());
			ps.setString(2, users.getPassword());
			ps.setInt(3, users.getMembership_id());
			ps.setBoolean(2, users.isEnabled());
			int result = ps.executeUpdate();
			if(result > 0) {
				System.out.println(result + "Record/s inserted");
			} else {
				System.out.println("No Records inserted");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Users> getAllUser() {
		List<Users> listOfUsers = new ArrayList<Users>();
		try {
			String query = "select * from users";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				Users user = new Users();
				user.setUser_id(rs.getInt(1));
				user.setEmail(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setMembership_id(rs.getInt(4));
				user.setEnabled(rs.getBoolean(5));
				
				listOfUsers.add(user);
				
			}
		} catch (SQLException e) {
		e.printStackTrace();
		}
		
		return listOfUsers;
	}

	@Override
	public void updateUser(Users users) {
		try {
			String query = "update users set email = ?, password = ?, membership_id = ? where user_id = ? ";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, users.getEmail());
			ps.setString(2, users.getPassword());
			ps.setInt(3, users.getMembership_id());
			ps.setInt(4, users.getUser_id());
			int result = ps.executeUpdate();
			if(result > 0) {
				System.out.println( result + "Record/s Inserted");
			} else {
				System.out.println("No Records Inserted");
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteUser(Users users) {
		try {
			String query = "delete from users where uaser_id = ? ";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, users.getUser_id());
			int result = ps.executeUpdate();
			if(result > 0) {
				System.out.println( result + "Record/s Deleted");
			} else {
				System.out.println("No Records Inserted");
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
		
	}

}
