package controllers;

import data.dao.UserDao;
import enums.AccountType;
import models.User;
import services.UserService;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet(value="/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private UserService userService = new UserService();
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");

		String name = request.getParameter("customer-name");
		String address = request.getParameter("customer-address");
		String phone = request.getParameter("customer-phone");

		User user = userService.getUserWithUsername(id);
		request.getSession().setAttribute("account-type", AccountType.Current.toString());

		user.setName(name);
		user.setAddress(address);
		user.setPhoneNumber(phone);
		new UserDao().update(user);
		userService.activate(user);

		session.setAttribute("user", user);
		request.getRequestDispatcher("homepage.jsp").forward(request, response);
	}

}
