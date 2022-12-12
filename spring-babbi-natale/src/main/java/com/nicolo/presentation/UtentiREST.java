package com.nicolo.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nicolo.dal.UtentiDAO;
import com.nicolo.entities.Utente;

@RestController
@RequestMapping("api")
public class UtentiREST {
	
	@Autowired
	UtentiDAO dao;
	
	@GetMapping("utenti")
	public List<Utente> stampaUtenti() {
		return dao.findAll();
	}
	
	@GetMapping("utenti/{id}")
	public Object stampaUtenteById(@PathVariable("id") int id) {
		return dao.findById(id);
	}
	
}
