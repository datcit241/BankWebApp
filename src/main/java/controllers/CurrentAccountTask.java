package controllers;

import enums.AccountType;
import enums.TransactionType;
import models.Account;
import models.User;
import services.AccountService;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet(value="/CurrentAccountTask")
public class CurrentAccountTask extends HttpServlet {
	private AccountService accountService = new AccountService();
	private static final long serialVersionUID = 1L;

	public CurrentAccountTask() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		User user = (User) session.getAttribute("user");

		TransactionType transactionType = TransactionType.valueOf(request.getParameter("transaction"));
		double amount = Double.parseDouble(request.getParameter("amount"));
		AccountType accountType  = AccountType.valueOf((String) request.getSession().getAttribute("account-type"));
		Account account = new AccountService().getUserAccount(user, accountType);

		System.out.println(transactionType);
		System.out.println(amount);
		System.out.println(accountType);
		System.out.println(account);

		boolean check = false;
		double getMoney = 0;

		if (transactionType == TransactionType.Deposit) {
			check = accountService.deposit(account, amount);
		} else if (transactionType == TransactionType.Withdraw) {
			check = accountService.withDraw(account, amount);
		} else if (transactionType == TransactionType.Transfer) {
			String id = request.getParameter("to-customer-id");
			Account toAccount = accountService.getAccountById(id);
			check = accountService.transfer(account, toAccount, amount);
		} else {
			request.getRequestDispatcher("error.jsp").forward(request, response);
			return;
		}

		request.setAttribute("action", transactionType.toString());
		request.setAttribute("status", check);
		request.setAttribute("money", getMoney);
		request.getRequestDispatcher("status.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
