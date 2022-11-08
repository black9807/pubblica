package controller;

import java.util.ArrayList;

import dao.UtenteDAO;
import model.Utente;

public class UtenteCtrl {
	
	public UtenteDAO dao = new UtenteDAO();
	
	public ArrayList<Utente> elencoUtenti(){
		return dao.getUtenti();
	}
	
//	public void addUtente(String username, String nome, String psw) {
//		dao.addUtente(new Utente(nome, username, psw));
//	}
	
	public void addUtente(Utente u) {
		dao.addUtente(u);
	}
	
	/**
	 * Ritorna se l'utente è già registrato oppure se il nome utente già esiste
	 */
	private boolean isValid(Utente uIns) {
		
		boolean valido = true;
		
		for (Utente u : elencoUtenti()) {
			
			if (u.getUsername().equals(uIns.getUsername())) {
				
				valido = false;
				
			}
			
			if (u.getPsw().equals(uIns.getPsw()) 
					&& u.getNome().equals(uIns.getNome())
					&& u.getUsername().equals(uIns.getUsername())) {
				
				valido = false;
				
			}
			
		}
		
		return valido;
		
	}
	
	public boolean register(Utente u) {
		
		if (isValid(u)) {
			
			addUtente(u);
			return true;
			
		}
		
		return false;
	}
	
	public boolean login(String username, String psw) {
		
		for (Utente u : elencoUtenti()) {
			
			return u.getUsername().equals(username) && u.getPsw().equals(psw) ? true : false;
			
		}
		
		return false;
		
	}
	
}
