<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<link rel="stylesheet" type="text/css" href="CSS/login.css">
</head>
<body>
	<div class="login-container">
		<h2>Login</h2>
		<form action="login" method="post">
			<select name="role" required>
				<option value="Student">Student</option>
				<option value="FacultyMember">Faculty Member</option>
				<option value="Administrator">Administrator</option>
			</select> <input type="text" name="username" placeholder="Username" required>
			<input type="password" name="password" placeholder="Password"
				required>

			<button type="submit">Login</button>
			
		</form>
	</div>
</body>
</html>