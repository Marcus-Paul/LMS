package com.lms.DAOImpli;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lms.DAO.UserDAO;
import com.lms.DAO.UserRoleDAO;
import com.lms.TableClassess.UserRole;
import com.lms.TableClassess.Users;

public class UserRoleDAOImpli implements UserRoleDAO {
	private final Connection connection;
	
	public UserRoleDAOImpli(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void insertUserRole(UserRole userRole) {
		try {
			String query = "insert into user_role (user_id, role_id) values (?,?)";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, userRole.getUser_id());
			ps.setInt(2, userRole.getRole_id());
			int result = ps.executeUpdate();
			if(result>0) {
				System.out.println(result + "Record/s Inserted");
			} else {
				System.out.println("No records inserted");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<UserRole> getAllUserRole() {
		List<UserRole> listOfUserRoles = new ArrayList<UserRole>();
		
		try {
			String query = "select * from user_role";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				UserRole userRole = new UserRole();
				userRole.setUser_id(rs.getInt(1));
				userRole.setRole_id(rs.getInt(2));
				listOfUserRoles.add(userRole);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listOfUserRoles;
	}

	@Override
	public void updateRole(UserRole userRole) {
		try {
			String query = "update user_role set role_id = ? where user_id = ?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, userRole.getRole_id());
			ps.setInt(2, userRole.getUser_id());
			int result = ps.executeUpdate();
			if(result > 0) {
				System.out.println(result + "Records/s updated");
			} else {
				System.out.println("No records updated");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteRole(UserRole userRole) {
		try {
			String query = "delete from user_role where user_id = ?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, userRole.getUser_id());
			int result = ps.executeUpdate();
			if(result > 0) {
				System.out.println(result + "Records/s Deleted");
			} else {
				System.out.println("No records Deleted");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
