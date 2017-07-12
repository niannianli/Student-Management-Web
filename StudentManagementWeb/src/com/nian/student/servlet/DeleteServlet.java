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

public class DeleteServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private LoginService loginService = new LoginService();
	private UserService userService = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		//get data from login html form
		Integer id = Integer.valueOf(req.getParameter("id"));
		userService.deleteUserById(id);
		
        List<User> userList = loginService.findAllUsers();		
        
        //set data to be used in jsp
		req.setAttribute("userList", userList);

		//now forward this page to dashiboard.jsp
		req.getRequestDispatcher("dashboard.jsp").forward(req, resp);		
	}
	
}
