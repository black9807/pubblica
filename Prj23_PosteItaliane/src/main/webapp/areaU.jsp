<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Area Utente</title>
</head>
<body>
	
	<h1>Area Utente</h1>
	
	<div>
		<% 
			if(request.getParameter("insert") != null){
					
				out.print(request.getParameter("insert"));

			}
		%>
	</div>
	
</body>
</html>