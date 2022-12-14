package controllers;

import data.dao.UserDao;
import enums.AccountType;
import models.User;
import services.UserService;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet(value="/ChangePassword")
public class ChangePassword extends HttpServlet {
	private UserService userService = new UserService();
	private static final long serialVersionUID = 1L;

	public ChangePassword() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		User user = userService.getUserWithUsername(id);
		user.setPassword(password);
		new UserDao().update(user);

		if (userService.isNewUser(user)) {
			request.getSession().setAttribute("account-type", AccountType.Current);
			request.getRequestDispatcher("register.jsp").forward(request, response);
		} else {
			PrintWriter out = response.getWriter();
			out.print("<h5 style='color: white; margin-left: 36%' Update Password Successfully</h5>");  
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
