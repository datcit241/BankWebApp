package controllers;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet(value="/switch-account-type")
public class AccountTypeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String type = req.getParameter("type");
        session.setAttribute("account-type", type);

        req.getRequestDispatcher("homepage.jsp").forward(req, resp);
    }
}
