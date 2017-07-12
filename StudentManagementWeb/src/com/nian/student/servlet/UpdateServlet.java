package com.nian.student.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nian.student.pojo.User;
import com.nian.student.service.LoginService;
import com.nian.student.service.UserService;

public class UpdateServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private LoginService loginService = new LoginService();
    private	UserService userService = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		Integer id = Integer.valueOf(req.getParameter("id"));
		
		User user = userService.getUserById(id);
		
		userService.updateUser(user);
		
		// this is the new user
		req.setAttribute("user", user);
		
		// new user list
        List<User> userList = loginService.findAllUsers();
		
        // set to be retrieved in jsp
		req.setAttribute("userList", userList);
		
		req.getRequestDispatcher("dashboard.jsp").forward(req, resp);		
	}

}

// now how to update the data after click on edit
// instead of insert a new record?
