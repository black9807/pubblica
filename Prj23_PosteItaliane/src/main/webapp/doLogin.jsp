<%@page import="controller.UtenteCtrl"%>
<%@page import="model.Utente"%>
<%

	String username = request.getParameter("username");
	String psw = request.getParameter("psw");
	
	UtenteCtrl ctrl = new UtenteCtrl();
	boolean valido = ctrl.login(username, psw);
	
	if (valido) {
		response.sendRedirect("areaU.jsp?insert=Login+avvenuto+con+successo");
	} else {
		response.sendRedirect("login.jsp?insert=Login+fallito");
	}

%>