package com.Login;

import com.DatabaseUtils.*;

import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class AdminServlet extends HttpServlet {


	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		RequestDispatcher rd = null;
		HttpSession session = req.getSession();
		UserClass user = (UserClass) session.getAttribute("user");
		PrintWriter out = res.getWriter();
		DbUtils db = new DbUtils();
		boolean isTheUserAdmin = db.checkIfAdmin(user.getUname(), user.getUpass());
		try {
		if (isTheUserAdmin) {
			session.setAttribute("user", user);
			req.getRequestDispatcher("adminControl.jsp").forward(req, res);
		}
		else {
			boolean isNormalUser = db.checkIfUser(user.getUname(), user.getUpass());
			if(isNormalUser) {
				session.setAttribute("user", user);
				req.getRequestDispatcher("welcomeUser.jsp").forward(req, res);
			}
			else {
				req.setAttribute("error","Invalid Username or Password");
				rd=req.getRequestDispatcher("/LoginGate.jsp");            
				rd.include(req, res);
				}
		}
		}
		 catch (ServletException e) {
			e.printStackTrace();
		}
	}
}