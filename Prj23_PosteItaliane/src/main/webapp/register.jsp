<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>

	<h1>Effettua la registrazione</h1>
		
	<form action="doRegister.jsp" method="post">
		<label for="username">Username</label>
		<input type="text" name="username" id="username">
		<label for="nome">Nome</label>
		<input type="text" name="nome" id="nome">
		<label for="psw">Password</label>
		<input type="password" name="psw" id="psw">
		
		<input type="submit" value="Registrati">
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