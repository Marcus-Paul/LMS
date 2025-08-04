package com.lms.DAOImpli;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.lms.DAO.RolesDAO;
import com.lms.TableClassess.Roles;

public class RoleDAOImpli implements RolesDAO {
	
	private final Connection connection;
	
	public  RoleDAOImpli(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void createRoles(Roles roles) {
		
		try {
			String query = "insert into roles (role_name) values (?)";
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setString(1, roles.getRole_name());
			int result = ps.executeUpdate();
			if(result>0) {
				System.out.println(result + "Record/s inserted");
			}
			else {
				System.out.println("No Records inserted");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public List<Roles> getAllRoles() {
		List<Roles> allRoles = new ArrayList<Roles>();
		
		try {
			
			String query = "select * from Roles";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Roles role = new Roles();
				role.setRole_id(rs.getInt(1));
				role.setRole_name(rs.getString(2));
				
				allRoles.add(role);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return allRoles;
	}

	@Override
	public void updateRole(Roles roles) {
		
		try {
			
			String query = "update roles set role_name = ? where role_id = ?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, roles.getRole_name());
			ps.setInt(2, roles.getRole_id());
			int result = ps.executeUpdate();
			if(result>0) {
				System.out.println(result + "No of record/s updated");
			} else {
				System.out.println("No records inserted");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteRole(Roles roles) {
		try {
			
			String query = "delete from roles where role_id = ?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, roles.getRole_id());
			int result = ps.executeUpdate();
			if(result>0) {
				System.out.println(result + "No of record/s updated");
			} else {
				System.out.println("No records inserted");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
