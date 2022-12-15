package com.nicolo.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nicolo.dal.SacchiDAO;
import com.nicolo.entities.Sacco;

@RestController
@RequestMapping("api")
public class SacchiREST {

	@Autowired
	SacchiDAO dao;
	
	@GetMapping("sacchi")
	public List<Sacco> findSacchi() {
		return dao.findAll();
	}
	
	@GetMapping("sacchi/{id}")
	public Object findSaccoById(@PathVariable("id") int id) {
		return dao.findById(id);
	}
	
}
