package com.nicolo.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("doni")
public class DoniMVC {
	
	@GetMapping("listaDoni")
	public String listaDoni(HttpSession session) {
		
		if (session.getAttribute("loggedUser") == null)
			return "redirect:/";
		
		return "listaDoni";	
	}
	
//	@postma
	
}
