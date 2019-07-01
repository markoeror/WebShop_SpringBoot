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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Stavke {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int kolicina;
	private int status;
	@OneToMany(mappedBy = "stavke", cascade = CascadeType.ALL,orphanRemoval = true)
	private Set<Artikal> setArtikala= new HashSet<>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_porudzbine")
	private Porudzbine porudzbine;
	
	
	
	public Porudzbine getPorudzbine() {
		return porudzbine;
	}
	public void setPorudzbine(Porudzbine porudzbine) {
		this.porudzbine = porudzbine;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Set<Artikal> getSetArtikala() {
		return setArtikala;
	}
	public void setSetArtikala(Set<Artikal> setArtikala) {
		this.setArtikala = setArtikala;
	}
	
	public void addArtikal(Artikal artikal) {
		setArtikala.add(artikal);
		artikal.setStavke(this);
	}
	
	public void removeArtikal(Artikal artikal) {
		setArtikala.remove(artikal);
		artikal.setStavke(null);
	}
	
	
}
