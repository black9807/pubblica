package com.nicolo.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nicolo.dal.BimbiDAO;
import com.nicolo.entities.Bimbo;

@RestController
@RequestMapping("api")
public class BimbiREST {
	
	@Autowired
	BimbiDAO dao;
	
	@GetMapping("bimbi")
	public List<Bimbo> stampaBimbi() {
		return dao.findAll();
	}
	
	
	@GetMapping("bimbi/{id}")
	public Object stampaBimbo(int id) {
		return dao.findById(id);
	}
	
}
