<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hospital Management System Login</title>
</head>
<body>
	<form action="login" method="post">
		<table
			style="background-color: steelblue; margin-left: 15px; margin-top: 15px;">
			<tr>
				<td><h3 style="color: black">Welcome to the Login Page !!</h3></td>
				<td></td>
			</tr>
			<tr>
				<td>Username:</td>
				<td><input type="text" name="user"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="pass"></td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="Login"></td>
				<td><a href="register.jsp">Registration</a></td>
			</tr>
		</table>
	</form>
</body>
</html>