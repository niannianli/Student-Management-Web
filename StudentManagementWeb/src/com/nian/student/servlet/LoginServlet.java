package com.nian.student.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nian.student.pojo.User;
import com.nian.student.service.LoginService;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private LoginService loginService = new LoginService();
	// no bugsiness logic

	// tomcat server internally maintain container and created the
	// servlet object and call this doPost method,
	// thats how the method is called

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// we are not using service method: can process request
		// as we already use post method: can process post request
        System.out.println("begin doPost()");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
        System.out.println(username);
        System.out.println(password);
		Boolean status = loginService.validateUser(username, password);

		if (status) {
			// resp.sendRedirect("dashboard.jsp");
			req.setAttribute("isLogin", true);

			List<User> userList = loginService.findAllUsers();

			req.setAttribute("userList", userList);

			//req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
			req.getRequestDispatcher("simple.jsp").forward(req, resp);

		} else {
			resp.sendRedirect("login.jsp");
		}

		// this needs 2 requests, better avoid this
		// resp.sendRedirect("dashboard.jsp");

		// user send request to servlet
		// then response immediately
		// request again for the specific jsp

		// servlet pass the request to jsp, then jsp response
		// req.getRequestDispatcher("dashboard.jsp").forward(req, resp);

	}

}

// start db

// user request1 submit--->servlet--->2 jsp pages ready
// ---->servlet response----> request2 and be directed to one jsp page

// value can be put in request1

// submit,

// when using: respRedirect(url);
// user request1->login servlet->response immediately->user
// user request2 another url->url page

// instead we do this:
// put information in user request: param: value-->login servlet
// to get information from user request:
// inside jsp page:
// instead creating a second user request
// login servlet can directly go to dashboard.jsp as response
// then response goes to user

// always stop server/clean project
// before running

// dynamic query using HQL

// how to debug application
// debug on server
// press F6 put breakpoint
// F8 stop

// open implemnetation
