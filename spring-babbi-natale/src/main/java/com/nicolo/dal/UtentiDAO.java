package com.nicolo.dal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nicolo.entities.Utente;

@Repository
public interface UtentiDAO extends JpaRepository<Utente, Integer> {

	/**
	 * Utilizzato principalmente per effettuare il login
	 * @param username dell'utente
	 * @param password dell'utente
	 * @return utente con quei parametri se esistente
	 */
	Utente findByUsernameEqualsAndPasswordEquals(String username, String password);
	
	/**
	 * Principalmente utilizzato per ritornare tutti i babbi natale (utente)
	 * @param tipo = utente o admin
	 * @return utenti di quel tipo
	 */
	List<Utente> findByTipo(String tipo);
	
}
