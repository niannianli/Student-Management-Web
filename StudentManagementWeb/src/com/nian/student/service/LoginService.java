package com.nian.student.service;

import java.util.List;

import com.nian.student.dao.UserDao;
import com.nian.student.pojo.User;

public class LoginService {

	private UserDao dao = new UserDao();

	public Boolean validateUser(String username, String password) {

		User user = dao.getUserByUsernameAndPassword(username, password);
		// we need to connect to jdbc
		// do not write your code here
		// business logic here
		// db in UserDao

		if (user == null) {
			return false;
		} else {
			return true;
		}

	}

	public List<User> findAllUsers() {

		return dao.findAllUsers();

	}

}
