package com.nicolo.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nicolo.dal.DoniDAO;
import com.nicolo.entities.Dono;

@RestController
@RequestMapping("api")
public class DoniREST {
	
	@Autowired
	DoniDAO dao;
	
	@GetMapping("doni")
	public List<Dono> stampaDoni() {
		return dao.findAll();
	}
	
	@GetMapping("doni/{id}")
	public Object stampaDono(int id) {
		return dao.findById(id);
	}
	
	@PostMapping("doni")
	public Dono addDono(Dono d) {
		return dao.save(d);
	}
	
}
