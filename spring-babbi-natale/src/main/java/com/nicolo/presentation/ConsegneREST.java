package com.nicolo.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nicolo.dal.ConsegneDAO;
import com.nicolo.entities.Consegna;

@RestController
@RequestMapping("api")
public class ConsegneREST {

	@Autowired
	ConsegneDAO dao;
	
	@GetMapping("consegne")
	public List<Consegna> stampaConsegne() {
		return dao.findAll();
	}
	
	@GetMapping("consegne/{id}")
	public Object stampaConsegna(@PathVariable("id") int id) {
		return dao.findById(id);
	}
	
}
