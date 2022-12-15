package com.nicolo.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nicolo.dal.BimbiDAO;
import com.nicolo.dal.ConsegneDAO;
import com.nicolo.dal.DoniDAO;
import com.nicolo.dal.SacchiDAO;
import com.nicolo.entities.Bimbo;
import com.nicolo.entities.Consegna;
import com.nicolo.entities.Sacco;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("doni")
public class DoniMVC {
	
	@Autowired
	DoniDAO dao;
	
	@GetMapping("listaDoni")
	public String listaDoni(HttpSession session) {
		
		if (session.getAttribute("loggedUser") == null)
			return "redirect:/";
		
		return "listaDoni";	
	}
	
}
