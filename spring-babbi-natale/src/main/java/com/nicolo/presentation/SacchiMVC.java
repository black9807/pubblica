package com.nicolo.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("sacchi")
public class SacchiMVC {
	
	@GetMapping("addDoni")
	public String addDoni(HttpSession session) {
		
		if (session.getAttribute("loggedUser") == null)
			return "redirect:/";
		
		return "addDoni";
	}
	
}
