package com.comtrade.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Artikal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String naziv;
	private int cena;
	private String barkod;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_kategorije")
	private Kategorije kategorije;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_stavke")
	private Stavke stavke;
	
	public Kategorije getKategorije() {
		return kategorije;
	}
	public void setKategorije(Kategorije kategorije) {
		this.kategorije = kategorije;
	}
	public Stavke getStavke() {
		return stavke;
	}
	public void setStavke(Stavke stavke) {
		this.stavke = stavke;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public int getCena() {
		return cena;
	}
	public void setCena(int cena) {
		this.cena = cena;
	}
	public String getBarkod() {
		return barkod;
	}
	public void setBarkod(String barkod) {
		this.barkod = barkod;
	}
	
	
	
}
