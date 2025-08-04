package com.lms.DAO;

import java.util.List;

import com.lms.TableClassess.UserRole;

public interface UserRoleDAO {
	void insertUserRole(UserRole userRole);
	List<UserRole> getAllUserRole();
	void updateRole(UserRole userRole);
	void deleteRole(UserRole userRole);
}
