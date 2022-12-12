package com.nicolo.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "utenti")
public class Utente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String password;
	private String nome;
	
	@Column(name = "mezzo_trasporto")
	private String mezzoTrasporto;
	private String zona;
	private String tipo;
	
	@OneToMany(mappedBy = "utente", fetch = FetchType.LAZY)
	private List<Consegna> consegne;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMezzoTrasporto() {
		return mezzoTrasporto;
	}
	public void setMezzoTrasporto(String mezzoTrasporto) {
		this.mezzoTrasporto = mezzoTrasporto;
	}
	public String getZona() {
		return zona;
	}
	public void setZona(String zona) {
		this.zona = zona;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public List<Consegna> getConsegne() {
		return consegne;
	}
	public void setConsegne(List<Consegna> consegne) {
		this.consegne = consegne;
	}
	@Override
	public String toString() {
		return "Utente [id=" + id + ", username=" + username + ", password=" + password + ", nome=" + nome
				+ ", mezzoTrasporto=" + mezzoTrasporto + ", zona=" + zona + ", tipo=" + tipo + ", consegne=" + consegne
				+ "]";
	}
	
}
