<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>Login Page</title>
</head>
<body>
	<div class="container"
		style="margin: 50px; width: 50%; border: 3px solid black; padding: 10px;">
		<h1>Login Page</h1>
		<%
		String login_msg=(String)request.getAttribute("error");  
		if(login_msg!=null)
		out.println("<font color=red size=4px>"+login_msg+"</font>");
		%>
		<form action="loginGate" method="post">
			<div class="form-group">

				<label for="username">Username</label> <input type="text"
					class="form-control" id="username" aria-describedby="username"
					placeholder="Enter Username" name="uname">
			</div>
			<div class="form-group">
				<label for="password">Password</label> <input type="password"
					class="form-control" id="loginPassword" placeholder="Password"
					name="upass">
			</div>
			<button type="submit" class="btn btn-success">Log In</button>
			<%
			if(login_msg!=null)
			out.print("<a href = 'Signup.jsp'><button class='btn btn-info'>Sign Up</button></a>");
			%>
		</form>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>

</body>
</html>