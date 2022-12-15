package com.nicolo.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nicolo.dal.BimbiDAO;
import com.nicolo.dal.ConsegneDAO;
import com.nicolo.dal.SacchiDAO;
import com.nicolo.entities.Bimbo;
import com.nicolo.entities.Consegna;
import com.nicolo.entities.Sacco;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("sacchi")
public class SacchiMVC {
	
	@Autowired
	SacchiDAO dao;
	
	@Autowired
	ConsegneDAO cDAO;
	
	@Autowired
	BimbiDAO bDAO;
	
	@GetMapping("addDoni")
	public String addDoni(HttpSession session) {
		
		if (session.getAttribute("loggedUser") == null)
			return "redirect:/";
		
		return "addDoni";
	}
	
	@PostMapping("changeDoni")
	public String mauro(@RequestParam("bimboId") int bimboId, @RequestParam("saccoId") int saccoId, HttpSession session) {
		
		if (session.getAttribute("loggedUser") == null)
			return "redirect:/";
		
		Bimbo bimbo = bDAO.findById(bimboId).get();
		Sacco sacco = dao.findById(saccoId).get();
		
		Consegna consegna = new Consegna();
		consegna.setBimbo(bimbo);
		consegna.setSacco(sacco);
		
		cDAO.save(consegna);
		
		return "addDoni";
	}
	
	@GetMapping("changeDoni")
	public String redirect(HttpSession session) {
		
		return addDoni(session);
	}
	
	@GetMapping("addSacchi")
	public String addSacchi(HttpSession session) {
		
		if (session.getAttribute("loggedUser") == null)
			return "redirect:/";
		
		return "addSacchi";
	}
	
}
