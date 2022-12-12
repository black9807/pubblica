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
import jakarta.persistence.OneToMany;
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
	
	@JsonIgnore
	@OneToMany(mappedBy = "sacco", fetch = FetchType.LAZY)
	private List<Consegna> consegne;

	@JsonIgnore
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

	@Override
	public String toString() {
		return "Sacco [id=" + id + ", nome=" + nome + ", assegnatoData=" + assegnatoData + ", assegnatoOra="
				+ assegnatoOra + ", consegne=" + consegne + ", bimbi=" + bimbi + "]";
	}
	
}
