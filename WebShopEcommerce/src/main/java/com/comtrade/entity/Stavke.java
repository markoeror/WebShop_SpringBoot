package com.comtrade.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Stavke {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int kolicina;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_porudzbine")
	private Porudzbine porudzbine;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Artikla")
	private Artikal artikal;
	
	public Porudzbine getPorudzbine() {
		return porudzbine;
	}
	public void setPorudzbine(Porudzbine porudzbine) {
		this.porudzbine = porudzbine;
	}
	public Artikal getArtikal() {
		return artikal;
	}
	public void setArtikal(Artikal artikal) {
		this.artikal = artikal;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getKolicina() {
		return kolicina;
	}
	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}
	
	
	/*
	 * public void addArtikal(Artikal artikal) { setArtikala.add(artikal);
	 * artikal.setStavke(this); }
	 * 
	 * public void removeArtikal(Artikal artikal) { setArtikala.remove(artikal);
	 * artikal.setStavke(null); }
	 */
	
	
}
