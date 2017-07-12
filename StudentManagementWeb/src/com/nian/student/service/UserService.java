package com.nian.student.service;

import java.util.List;

import com.nian.student.dao.UserDao;
import com.nian.student.pojo.User;

public class UserService {
	
	private UserDao dao = new UserDao();

	public User getUserById(Integer id){
		return dao.getUserById(id);
	}
	
	public void deleteUserById(Integer id) {
		dao.deleteUserById(id);
	}
	
	//...more methods

	public void addUser(User user) {
		dao.addUser(user);
		
	}

	public void updateUser(User user) {
		dao.updateUser(user);
	}
	
}
