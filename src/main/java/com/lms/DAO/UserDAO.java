package com.lms.DAO;

import java.util.List;

import com.lms.EntityClasses.User;

public interface UserDAO {
	void createUser(String userEmail, String userPassword, int membershipId, boolean enabled, int roleId);
	List<User> getAllUser();
	void updateUser(int userId, String userEmail, String userPassword, int membershipId, boolean enabled, int roleId);
	void deleteUser(int userId);
}
