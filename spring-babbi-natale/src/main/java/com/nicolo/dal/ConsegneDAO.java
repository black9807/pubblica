package com.nicolo.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nicolo.entities.Consegna;

@Repository
public interface ConsegneDAO extends JpaRepository<Consegna, Integer> {
	
}
