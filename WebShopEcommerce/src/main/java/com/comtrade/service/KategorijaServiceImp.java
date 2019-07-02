package com.comtrade.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comtrade.entity.Kategorije;
import com.comtrade.repository.KategorijaRepository;

import antlr.collections.List;

@Service
public class KategorijaServiceImp implements KategorijaService {
	private KategorijaRepository kategorijaRepository;
	@Autowired
	public KategorijaServiceImp(KategorijaRepository kategorijaRepository) {
		super();
		this.kategorijaRepository = kategorijaRepository;
	}

	@Override
	@Transactional
	public void save(Kategorije kategorije) {
		kategorijaRepository.save(kategorije);
		
	}

	@Override
	@Transactional
	public java.util.List<Kategorije> getKategorijeList() {
		
		return kategorijaRepository.findAll();
	}

	

}
