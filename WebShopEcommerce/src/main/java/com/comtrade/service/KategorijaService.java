package com.comtrade.service;

import java.util.List;

import com.comtrade.entity.Kategorije;

public interface KategorijaService {

	void save(Kategorije kategorije);

	List<Kategorije> getKategorijeList();

}
