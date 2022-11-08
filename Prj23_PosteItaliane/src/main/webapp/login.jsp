<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

	<h1>Effettua il login</h1>
		
	<form action="doLogin.jsp" method="post">
		<label for="username">Username</label>
		<input type="text" name="username" id="username">
		<label for="psw">Password</label>
		<input type="password" name="psw" id="psw">
		
		<input type="submit" value="Login">
	</form>
	
	<div>
		<% 
			if(request.getParameter("insert") != null){
					
				out.print(request.getParameter("insert"));

			}
		%>
	</div>
	
</body>
</html>