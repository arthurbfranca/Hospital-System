<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hospital Management System Registration</title>
</head>
<body>
	<form action="register" method="post">
		<table
			style="background-color: steelblue; margin-left: 15px; margin-top: 15px;">
			<tr>
				<td><h3 style="color: black">Welcome to the Registration Page !!</h3></td>
				<td></td>
			</tr>
			<tr>
				<td>Account Type:</td>
				<td><select name="accountType">
					<option value ="patient">Patient</option>
					<option value ="doctor">Doctor</option>
					<option value ="nurse">Nurse</option>
					<option value ="admin">Administration</option>
				</select></td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Username:</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="pass1"></td>
			</tr>
			<tr>
				<td>Re-Enter Password:</td>
				<td><input type="password" name="pass2"></td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="Register"></td>
				<td></td>
			</tr>
		</table>
	</form>
</body>
</html>