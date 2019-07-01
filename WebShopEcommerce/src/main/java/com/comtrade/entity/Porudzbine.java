package com.comtrade.entity;

import java.util.Date;
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
public class Porudzbine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date datum;
	@ManyToOne(fetch =FetchType.LAZY)
	@JoinColumn(name="id_user")
	private User user;
	
	@OneToMany(mappedBy = "porudzbine", cascade = CascadeType.ALL,orphanRemoval = true)
	private Set<Stavke> setStavki= new HashSet<>();
	
	
	public Set<Stavke> getSetStavki() {
		return setStavki;
	}
	public void setSetStavki(Set<Stavke> setStavki) {
		this.setStavki = setStavki;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public void addStavku(Stavke stavke) {
		setStavki.add(stavke);
		stavke.setPorudzbine(this);
	}
	
	public void removeStavke(Stavke stavke) {
		setStavki.remove(stavke);
		stavke.setPorudzbine(null);
	}
	
}
