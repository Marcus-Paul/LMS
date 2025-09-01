package com.lms.DAO;

import java.util.List;

import com.lms.EntityClasses.Role;

public interface RoleDAO {
	void createRole(Role roles);
	List<Role> getAllRoles();
	void updateRole(Role roles);
	void deleteRole(int roleId);
	
}
