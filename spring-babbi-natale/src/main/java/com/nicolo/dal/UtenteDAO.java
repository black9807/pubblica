package com.nicolo.dal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nicolo.entities.Utente;

@Repository
public interface UtenteDAO extends JpaRepository<Utente, Integer> {

	List<Utente> findByTipo(String tipo);
	
}
