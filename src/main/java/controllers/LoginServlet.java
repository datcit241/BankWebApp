package controllers;

import enums.AccountType;
import models.User;
import services.AccountService;
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
				if (userService.isNewUser(user)) {
					session.setAttribute("id", id);
					request.getRequestDispatcher("change_password.jsp").forward(request, response);
				} else {
					session.setAttribute("user", user);
					session.setAttribute("account-type", AccountType.Current.toString());

					request.getRequestDispatcher("homepage.jsp").forward(request, response);
				}
			} catch (Exception e) {
				request.getRequestDispatcher("error.jsp").forward(request, response);
				e.printStackTrace();
			}
		} else {
			request.getRequestDispatcher("index.jsp").include(request, response);
		}
	}
}
