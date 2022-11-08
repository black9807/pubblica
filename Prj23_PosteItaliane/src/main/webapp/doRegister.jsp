<%@page import="controller.UtenteCtrl"%>
<%@page import="model.Utente"%>
<%

	String username = request.getParameter("username");
	String nome = request.getParameter("nome");
	String psw = request.getParameter("psw");
	
	Utente u = new Utente(nome, username, psw);
	UtenteCtrl ctrl = new UtenteCtrl();
	boolean valido = ctrl.register(u);
	
	if (valido) {
		response.sendRedirect("areaU.jsp?insert=Registrazione+avvenuta+con+successo");
	} else {
		response.sendRedirect("register.jsp?insert=Registrazione+fallita");
	}

%>