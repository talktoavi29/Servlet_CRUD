package com.DatabaseUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.Login.UserClass;

public class DbUtils {

	private String url = "jdbc:mysql://localhost:3306/login";
	private String username = "root";
	private String password = "";
	boolean status = false;

	public boolean checkIfAdmin(String checkUname, String checkUpass) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM new_table WHERE adminId=? and adminPassword=?");
			ps.setString(1, checkUname);
			ps.setString(2, checkUpass);
			ResultSet rs = ps.executeQuery();
			status = rs.next();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// System.out.println(status);
		return status;
	}

	public void print() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, username, password);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from users");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
			}
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean checkIfUser(String checkUname, String checkUpass) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE username=? and password=?");
			ps.setString(1, checkUname);
			ps.setString(2, checkUpass);
			ResultSet rs = ps.executeQuery();
			status = rs.next();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// System.out.println(status);
		return status;
	}

	public boolean createNewAccount(String registerUname, String registerUpass) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO users (username,password) VALUES (?,?);");
			ps.setString(1, registerUname);
			ps.setString(2, registerUpass);
			int i = ps.executeUpdate();
			if (i > 0)
				status = true;
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public List<UserClass> listAllUsers() throws SQLException{
		List<UserClass> listUsers = new ArrayList<UserClass>();
		try {
				int i = 0;
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection(url, username, password);
				PreparedStatement ps = conn.prepareStatement("Select * From users");
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					UserClass user = new UserClass(rs.getString(2), rs.getString(3));
					listUsers.set(i, user);
					i++;
				}				
				conn.close();
	}
		catch (Exception e) {e.printStackTrace();}
		return listUsers;
	}
}