package com.lms.DAO;

import java.util.List;

import com.lms.TableClassess.Roles;

public interface RolesDAO {
	void createRoles(Roles roles);
	List<Roles> getAllRoles();
	void updateRole(Roles roles);
	void deleteRole(Roles roles);
	
}
