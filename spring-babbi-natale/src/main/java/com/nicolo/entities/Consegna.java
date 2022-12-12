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
	@JoinColumn(name = "sacco_id")
	private Sacco sacco;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dono_id")
	private Dono dono;
	private int quantita;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bimbo_id")
	private Bimbo bimbo;
	
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
	
	public Sacco getSacco() {
		return sacco;
	}
	
	public void setSacco(Sacco sacco) {
		this.sacco = sacco;
	}
	
	public Dono getDono() {
		return dono;
	}
	
	public void setDono(Dono dono) {
		this.dono = dono;
	}
	
	public int getQuantita() {
		return quantita;
	}
	
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	
	public Bimbo getBimbo() {
		return bimbo;
	}
	
	public void setBimbo(Bimbo bimbo) {
		this.bimbo = bimbo;
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
	
	@Override
	public String toString() {
		return "Consegna [id=" + id + ", sacco=" + sacco + ", dono=" + dono + ", quantita=" + quantita + ", bimbo="
				+ bimbo + ", consegnatoData=" + consegnatoData + ", consegnatoOra=" + consegnatoOra + ", annullato="
				+ annullato + "]";
	}
	
}
