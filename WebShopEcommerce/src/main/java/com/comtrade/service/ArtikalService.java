package com.comtrade.service;

import java.util.List;

import com.comtrade.entity.Artikal;
import com.comtrade.entity.Kategorije;

public interface ArtikalService {

	void save(Artikal artikal);
	List<Artikal> listaArtikla();
	Artikal getArtikal(int artikalId);
	List<Artikal> listaArtikalaZaK(Kategorije k);
}
