package com.nicolo.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "sacchi")
public class Sacco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	
	@Column(columnDefinition = "DATE", name = "assegnato_data")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate assegnatoData;
	
	@Column(columnDefinition = "TIME", name = "assegnato_ora")
	@DateTimeFormat(iso = ISO.TIME)
	private LocalTime assegnatoOra;
	
	@Column(columnDefinition = "DATE", name = "consegnato_data")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate consegnatoData;
	
	@Column(columnDefinition = "TIME", name = "consegnato_ora")
	@DateTimeFormat(iso = ISO.TIME)
	private LocalTime consegnatoOra;
	
	@Column(columnDefinition = "int default 0")
	private int annullato; // 0 = no (default) | 1 = si
	
	// @JsonIgnore
	@ManyToMany(mappedBy = "sacchi", fetch = FetchType.LAZY)
	private List<Utente> utenti;

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

	public LocalDate getAssegnatoData() {
		return assegnatoData;
	}

	public void setAssegnatoData(LocalDate assegnatoData) {
		this.assegnatoData = assegnatoData;
	}

	public LocalTime getAssegnatoOra() {
		return assegnatoOra;
	}

	public void setAssegnatoOra(LocalTime assegnatoOra) {
		this.assegnatoOra = assegnatoOra;
	}

	public LocalDate getConsegnatoData() {
		return consegnatoData;
	}

	public void setConsegnatoData(LocalDate consegnatoData) {
		this.consegnatoData = consegnatoData;
	}

	public LocalTime getConsegnatoOra() {
		return consegnatoOra;
	}

	public void setConsegnatoOra(LocalTime consegnatoOra) {
		this.consegnatoOra = consegnatoOra;
	}

	public int getAnnullato() {
		return annullato;
	}

	public void setAnnullato(int annullato) {
		this.annullato = annullato;
	}

	@JsonIgnore
	public List<Utente> getUtenti() {
		return utenti;
	}

	public void setUtenti(List<Utente> utenti) {
		this.utenti = utenti;
	}

	@Override
	public String toString() {
		return "Sacco [id=" + id + ", nome=" + nome + ", assegnatoData=" + assegnatoData + ", assegnatoOra="
				+ assegnatoOra + ", consegnatoData=" + consegnatoData + ", consegnatoOra=" + consegnatoOra
				+ ", annullato=" + annullato + ", utenti=" + utenti + "]";
	}
	
}
