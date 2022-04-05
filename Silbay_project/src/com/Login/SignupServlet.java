package com.Login;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.DatabaseUtils.DbUtils;

public class SignupServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		UserClass user = new UserClass(req.getParameter("uname"), req.getParameter("upass"));
		HttpSession session = req.getSession();
		DbUtils db = new DbUtils();
		boolean userSignUpVar = db.createNewAccount(user.getUname(), user.getUpass());
			
		if (userSignUpVar) {
			session.setAttribute("user", user);
			req.getRequestDispatcher("welcomeUser.jsp").forward(req, res);
	}
	}
}
