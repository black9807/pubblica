package com.nicolo.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "sacchi")
public class Sacco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	
	@OneToMany(mappedBy = "sacco", fetch = FetchType.LAZY)
	private List<Consegna> consegne;

	@OneToMany(mappedBy = "sacco", fetch = FetchType.LAZY)
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

	public List<Consegna> getConsegne() {
		return consegne;
	}

	public void setConsegne(List<Consegna> consegne) {
		this.consegne = consegne;
	}

	public List<Bimbo> getBimbi() {
		return bimbi;
	}

	public void setBimbi(List<Bimbo> bimbi) {
		this.bimbi = bimbi;
	}

	@Override
	public String toString() {
		return "Sacco [id=" + id + ", nome=" + nome + ", consegne=" + consegne + ", bimbi=" + bimbi + "]";
	}
	
}
