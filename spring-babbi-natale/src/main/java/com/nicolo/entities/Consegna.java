package com.nicolo.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "consegne")
public class Consegna {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "utente_id")
	private Utente utente;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sacco_id")
	private Sacco sacco;
	
	@Column(columnDefinition = "DATE", name = "consegnato_data")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate consegnatoData;
	
	@Column(columnDefinition = "TIME", name = "consegnato_ora")
	@DateTimeFormat(iso = ISO.TIME)
	private LocalTime consegnatoOra;
	
	@Column(columnDefinition = "int default 0")
	private int annullato; // 0 = no (default) | 1 = si

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
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

	public Sacco getSacco() {
		return sacco;
	}

	public void setSacco(Sacco sacco) {
		this.sacco = sacco;
	}

	@Override
	public String toString() {
		return "Consegna [id=" + id + ", utente=" + utente + ", sacco=" + sacco + ", consegnatoData=" + consegnatoData
				+ ", consegnatoOra=" + consegnatoOra + ", annullato=" + annullato + "]";
	}
	
}
