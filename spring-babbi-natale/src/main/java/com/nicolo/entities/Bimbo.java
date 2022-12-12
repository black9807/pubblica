package com.nicolo.entities;

import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "bimbi")
public class Bimbo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String indirizzo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinTable(name = "bimbi_doni",
			joinColumns = {
					@JoinColumn(name = "bimbo_id", referencedColumnName = "id",
							nullable = false, updatable = false)},
			inverseJoinColumns = {
					@JoinColumn(name = "bimbo_id", referencedColumnName = "id",
							nullable = false, updatable = false)}
	)
	private List<Dono> doni;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sacco_id")
	private Sacco sacco;
	
	private LocalTime consegnato;
	
	@Column(columnDefinition = "int default 0")
	private int annullato; // 0 = no (default) | 1 = si

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

	public Sacco getSacco() {
		return sacco;
	}

	public void setSacco(Sacco sacco) {
		this.sacco = sacco;
	}

	public LocalTime getConsegnato() {
		return consegnato;
	}

	public void setConsegnato(LocalTime consegnato) {
		this.consegnato = consegnato;
	}

	public int getAnnullato() {
		return annullato;
	}

	public void setAnnullato(int annullato) {
		this.annullato = annullato;
	}

	public List<Dono> getDoni() {
		return doni;
	}

	public void setDoni(List<Dono> doni) {
		this.doni = doni;
	}

	@Override
	public String toString() {
		return "Bimbo [id=" + id + ", nome=" + nome + ", indirizzo=" + indirizzo + ", doni=" + doni + ", sacco=" + sacco
				+ ", consegnato=" + consegnato + ", annullato=" + annullato + "]";
	}
	
}
