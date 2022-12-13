package com.nicolo.entities;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "utenti_sacchi",
			joinColumns = {
					@JoinColumn(name = "utente_id", referencedColumnName = "id",
							nullable = false, updatable = false)},
			inverseJoinColumns = {
					@JoinColumn(name = "sacco_id", referencedColumnName = "id",
							nullable = false, updatable = false)}
	)
	private Set<Sacco> sacchi;

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

	public Set<Sacco> getSacchi() {
		return sacchi;
	}

	public void setSacchi(Set<Sacco> sacchi) {
		this.sacchi = sacchi;
	}

	// @Override
	// public String toString() {
	// 	return "Utente [id=" + id + ", username=" + username + ", password=" + password + ", nome=" + nome
	// 			+ ", mezzoTrasporto=" + mezzoTrasporto + ", zona=" + zona + ", tipo=" + tipo + ", sacchi=" + sacchi
	// 			+ ", getId()=" + getId() + ", getUsername()=" + getUsername() + ", getPassword()=" + getPassword()
	// 			+ ", getNome()=" + getNome() + ", getMezzoTrasporto()=" + getMezzoTrasporto() + ", getZona()="
	// 			+ getZona() + ", getTipo()=" + getTipo() + ", getSacchi()=" + getSacchi() + ", getClass()=" + getClass()
	// 			+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	// }
	
}
