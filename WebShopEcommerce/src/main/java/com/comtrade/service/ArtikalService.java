package com.comtrade.service;

import java.util.List;

import com.comtrade.entity.Artikal;

public interface ArtikalService {

	void save(Artikal artikal);
	List<Artikal> listaArtikla();
	Artikal getArtikal(int artikalId);
	List<Artikal> listaArtiklaZaKat(int id);
}
