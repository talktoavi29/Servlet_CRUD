package com.Login;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DatabaseUtils.DbUtils;


public class AdminFunctionalities extends HttpServlet{
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		RequestDispatcher rd;
		UserClass user = new UserClass(req.getParameter("uname"), req.getParameter("upass"));
		DbUtils db = new DbUtils();
		boolean createUserVar = db.createNewAccount(user.getUname(), user.getUpass());
		if (createUserVar) {
			rd=req.getRequestDispatcher("/adminControl.jsp");            
			rd.include(req, res);	
		}
		else {
			
		}
}
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		RequestDispatcher rd;
		DbUtils db = new DbUtils();
		try {
			List listaddusers =  db.listAllUsers();
			req.setAttribute("userlist", listaddusers); 
			rd = getServletContext().getRequestDispatcher("/adminControl.jsp");  
			rd.forward(req, res);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
}