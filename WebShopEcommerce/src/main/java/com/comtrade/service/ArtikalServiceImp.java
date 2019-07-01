package com.comtrade.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comtrade.entity.Artikal;
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

}
