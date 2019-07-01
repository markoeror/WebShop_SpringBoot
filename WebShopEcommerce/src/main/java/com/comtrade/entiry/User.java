package com.comtrade.entiry;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String password;
	private int status;
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL,orphanRemoval = true)
	private Set<Porudzbine> setPorudzbina= new HashSet<>();
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	@Override
	public int hashCode() {
		
		return 31;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	public void addLPorudzbinu(Porudzbine porudzbine) {
		setPorudzbina.add(porudzbine);
		porudzbine.setUser(this);
	}
	
	public void removeLjubimac(Porudzbine porudzbine) {
		setPorudzbina.remove(porudzbine);
		porudzbine.setUser(null);
	}
	
	
}
