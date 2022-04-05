package com.Login;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.servlet.http.HttpServletRequest;

public class UserClass {
	private String uname;
	private String upass;

	protected String getUname() {
		return uname;
	}

	protected String getUpass() {
		return upass;
	}

	public UserClass(String uname, String upass) {
		this.uname = uname;
		this.upass = upass;
	}

	public UserClass(Object object) {
		this.uname = uname;
		this.upass = upass;
	}

	public void print() throws NoSuchAlgorithmException {
		System.out.println(
				"Hello " + uname + " your password is protected and if someone tries to hack it, it will show like:");
		System.out.print(passwordProtectionMethod(upass));
	}

	private byte[] passwordProtectionMethod(String upass) throws NoSuchAlgorithmException {
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[16];
		random.nextBytes(salt);
		MessageDigest md = MessageDigest.getInstance("SHA-512");
		md.update(salt);
		byte[] hashedPassword = md.digest(upass.getBytes(StandardCharsets.UTF_8));
		return hashedPassword;
	}
}