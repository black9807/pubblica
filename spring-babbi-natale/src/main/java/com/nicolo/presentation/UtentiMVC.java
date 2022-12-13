package com.nicolo.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nicolo.dal.UtentiDAO;
import com.nicolo.entities.Utente;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("utenti")
public class UtentiMVC {
	
	@Autowired
	UtentiDAO dao;
	
	@PostMapping("loginCheck")
	public String loginCheck(HttpSession session, HttpServletRequest request) {
		
		String username = request.getParameter("username");
		String password = request.getParameter("inputPassword");
		Utente utente = dao.findByUsernameEqualsAndPasswordEquals(username, password);
		System.out.println(utente);
		if (utente != null) {
			
			session.setAttribute("loggedUser", utente);
			
			return "homePage";
			
		} else 
			return "redirect:/";
		
	}
	
	@GetMapping("loginCheck")
	public String redirect() { return "redirect:/"; }
}
