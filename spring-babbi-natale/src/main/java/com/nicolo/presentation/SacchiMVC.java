package com.nicolo.presentation;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nicolo.dal.BimbiDAO;
import com.nicolo.dal.ConsegneDAO;
import com.nicolo.dal.SacchiDAO;
import com.nicolo.dal.UtentiDAO;
import com.nicolo.entities.Bimbo;
import com.nicolo.entities.Consegna;
import com.nicolo.entities.Sacco;
import com.nicolo.entities.Utente;

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
	
	@Autowired
	UtentiDAO uDAO;
	
	@GetMapping("addDoni")
	public String addDoni(HttpSession session) {
		
		if (session.getAttribute("loggedUser") == null)
			return "redirect:/";
		
		return "addDoni";
	}
	
	@PostMapping("changeDoni")
	public String changeDoni(@RequestParam("bimboId") int bimboId, @RequestParam("saccoId") int saccoId, HttpSession session) {
		
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
	
	@PostMapping("changeSacchi")
	public String changeSacchi(@RequestParam("babboId") int babboId, @RequestParam("saccoId") int saccoId, HttpSession session) {
		
		if (session.getAttribute("loggedUser") == null)
			return "redirect:/";
		
		Utente utente = uDAO.findById(babboId).get();
		Sacco sacco = dao.findById(saccoId).get();
		
		List<Utente> utenti = sacco.getUtenti();
		utenti.add(utente);
		
		sacco.setUtenti(utenti);
		
		Set<Sacco> sacchi = utente.getSacchi();
		sacchi.add(sacco);
		
		utente.setSacchi(sacchi);
		
		sacco.setAssegnatoData(LocalDate.now());
		sacco.setAssegnatoOra(LocalTime.now());
//		System.out.println(sacco);
		dao.save(sacco);
		
		return "addSacchi";
	}
	
	@GetMapping("changeSacchi")
	public String redirectSacchi(HttpSession session) {
		
		return addSacchi(session);
	}
	
}
