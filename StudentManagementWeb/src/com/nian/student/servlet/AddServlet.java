package com.nian.student.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nian.student.pojo.User;
import com.nian.student.service.LoginService;
import com.nian.student.service.UserService;

public class AddServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UserService userService = new UserService();
	private LoginService loginService = new LoginService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
	
		try{
			// if no current form, insert data
			if(req.getParameter("id") == null ||
					req.getParameter("id").isEmpty()){
				
				Integer id = Integer.valueOf(req.getParameter("id"));
				
				User user = userService.getUserById(id);
				
				userService.addUser(user);
				
				List<User> userList = loginService.findAllUsers();

				req.setAttribute("userList", userList);

				req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
				
			}else{
				// if there is id with current form, update data only
				Integer id = Integer.valueOf(req.getParameter("id"));
				
				User user = userService.getUserById(id);
				
				String name = req.getParameter("name");
				String address = req.getParameter("address");
				String username = req.getParameter("username");
				String password = req.getParameter("password");
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");			
				Date dob = sdf.parse(req.getParameter("dob"));
				
				user = new User();
				user.setName(name);
				user.setAddress(address);
				user.setUsername(username);
				user.setPassword(password);
				user.setDob(dob);
				
				userService.updateUser(user);
				
				// this is the new user
				req.setAttribute("user", user);
				
				// new user list
		        List<User> userList = loginService.findAllUsers();
				
		        // set to be retrieved in jsp
				req.setAttribute("userList", userList);
				
				req.getRequestDispatcher("dashboard.jsp").forward(req, resp);				
			}
		
	}catch(Exception e){
			
		}
		
		
}
}

// click Edit
// data should be populated, so we can edit

//session management?????

// jsp servlet is better: 

// using jquery for validation: is there any input yet?
// client
// server 
// validation: data exist, data type
// jquery, javascript,

// jquery validation framework: just copy the source code



// Spring, MVC???????????????????

// http session:track user info : 

// https: security

// using different servlets, no matter how many servlets
// requests are always created new/fresh

// but how many sessions are created?
// only 2 sessions, each session for each user

// user1: 3 requests: 
// user2: 2 requests:

// finish java, get a job, move, that's all!
// Spring framework, MVC

// session

//jquery, javascript review.

//

