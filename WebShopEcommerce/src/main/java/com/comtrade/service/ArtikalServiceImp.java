package com.comtrade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comtrade.entity.Artikal;
import com.comtrade.entity.Kategorije;
import com.comtrade.repository.ArtikalRepository;

@Service
public class ArtikalServiceImp implements ArtikalService {
	private ArtikalRepository artikalRepository;
	
	
	

	@Autowired
	public ArtikalServiceImp(ArtikalRepository artikalRepository) {
		super();
		this.artikalRepository = artikalRepository;
	}

	@Override
	@Transactional
	public void save(Artikal artikal) {
	artikalRepository.save(artikal);
		
	}

	@Override
	@Transactional
	public List<Artikal> listaArtikla() {
		
		return artikalRepository.findAll();
	}

	@Override
	@Transactional
	public Artikal getArtikal(int artikalId) {
		
		return artikalRepository.findArtikalById(artikalId);
	}

	@Override
	@Transactional
	public List<Artikal> listaArtikalaZaK(Kategorije k) {
		
		return artikalRepository.listaArtikalaZaK(k);
	}

}
