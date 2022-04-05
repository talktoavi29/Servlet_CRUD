package com.Login;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;


//This servlet checks if the user trying to login is a admin or a normal user.

public class LoginServlet extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		UserClass user = new UserClass(req.getParameter("uname"), req.getParameter("upass"));
		HttpSession session = req.getSession();
		session.setAttribute("user", user);
		
		RequestDispatcher rd;
		rd = req.getRequestDispatcher("admin");
		rd.forward(req, res);
}
}