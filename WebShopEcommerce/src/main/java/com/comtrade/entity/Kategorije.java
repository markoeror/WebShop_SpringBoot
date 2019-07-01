package com.comtrade.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Kategorije {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String naziv;
	@OneToMany(mappedBy = "kategorije", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Artikal>setArtikala=new HashSet();
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
	public Set<Artikal> getSetArtikala() {
		return setArtikala;
	}
	public void setSetArtikala(Set<Artikal> setArtikala) {
		this.setArtikala = setArtikala;
	}
	
}
