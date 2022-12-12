package com.nicolo.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "doni")
public class Dono {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private int disponibilita;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "dono", fetch = FetchType.LAZY)
	private List<Bimbo> bimbi;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getDisponibilita() {
		return disponibilita;
	}

	public void setDisponibilita(int disponibilita) {
		this.disponibilita = disponibilita;
	}

	public List<Bimbo> getBimbi() {
		return bimbi;
	}

	public void setBimbi(List<Bimbo> bimbi) {
		this.bimbi = bimbi;
	}

	@Override
	public String toString() {
		return "Dono [id=" + id + ", nome=" + nome + ", disponibilita=" + disponibilita + ", bimbi=" + bimbi + "]";
	}
	
}
