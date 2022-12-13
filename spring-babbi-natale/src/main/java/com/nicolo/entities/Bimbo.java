package com.nicolo.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "bimbi")
public class Bimbo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String indirizzo;
	
	@JsonIgnore
	@OneToMany(mappedBy = "bimbo", fetch = FetchType.LAZY)
	private List<Consegna> consegne;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "bimbi_doni",
	joinColumns = {
			@JoinColumn(name = "bimbo_id", referencedColumnName = "id",
					nullable = false, updatable = false)},
	inverseJoinColumns = {
			@JoinColumn(name = "dono_id", referencedColumnName = "id",
					nullable = false, updatable = false)}
			)
	private List<Dono> doni;

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

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public List<Consegna> getConsegne() {
		return consegne;
	}

	public void setConsegne(List<Consegna> consegne) {
		this.consegne = consegne;
	}

	public List<Dono> getDoni() {
		return doni;
	}

	public void setDoni(List<Dono> doni) {
		this.doni = doni;
	}

	@Override
	public String toString() {
		return "Bimbo [id=" + id + ", nome=" + nome + ", indirizzo=" + indirizzo + ", consegne=" + consegne + ", doni="
				+ doni + "]";
	}
	
}
