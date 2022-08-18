package controllers;

import models.User;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet(value="/LoginServlet")
public class LoginServlet extends HttpServlet {
	private UserService userService = new UserService();
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		String id = request.getParameter("id");
		String password = request.getParameter("password");

		User user = userService.getUserWithUsername(id);

		if (user != null && user.getPassword().equals(password)) {
			try {
				boolean flag = userService.isNewUser(user);

				if (flag) {
					session.setAttribute("id", id);
					request.getRequestDispatcher("change_password.jsp").forward(request, response);
				} else {
					session.setAttribute("user", user);
					request.getRequestDispatcher("homepage.jsp").forward(request, response);
				}
			} catch (Exception e) {
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		} else {
			request.getRequestDispatcher("index.jsp").include(request, response);
		}
	}
}