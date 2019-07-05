package com.comtrade.service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comtrade.entity.Porudzbine;
import com.comtrade.entity.Stavke;
import com.comtrade.entity.User;
import com.comtrade.repository.KategorijaRepository;
import com.comtrade.repository.PorudzbinaRepository;
import com.comtrade.repository.StavkeRepository;

@Service
public class StavkaServiceImp implements StavkaService {
	private StavkeRepository stavkeRepository;
	private PorudzbinaRepository porudzbinaRepository;
	
	@Autowired
	public StavkaServiceImp(StavkeRepository stavkeRepository,PorudzbinaRepository porudzbinaRepository) {
		super();
		this.stavkeRepository = stavkeRepository;
		this.porudzbinaRepository=porudzbinaRepository;
	}

	@Override
	@Transactional
	public void insertKupovine(ArrayList<Stavke> lista, User user) {
		long idUser=user.getId();
		Date date= Date.valueOf(LocalDateTime.now().toLocalDate());
		Porudzbine porudzbina= new Porudzbine();
		porudzbina.setDatum(date);
		porudzbina.setUser(user);
		Porudzbine porudzbina1= porudzbinaRepository.save(porudzbina);
		long idPorudzbine= porudzbina1.getId();		
		for(Stavke s:lista) {
			Stavke s1= new Stavke();
			s1.setPorudzbine(porudzbina1);
			s1.setArtikal(s.getArtikal());
			s1.setKolicina(s.getKolicina());
			stavkeRepository.save(s1);
		}				
	}
	

}
