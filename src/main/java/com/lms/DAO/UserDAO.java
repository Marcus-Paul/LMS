package com.lms.DAO;

import java.util.List;

import com.lms.TableClassess.Users;

public interface UserDAO {
	void createUser(Users users);
	List<Users> getAllUser();
	void updateUser(Users users);
	void deleteUser(Users users);
}
