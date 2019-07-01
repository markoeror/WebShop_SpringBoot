package com.comtrade.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.comtrade.entity.Kategorije;
import com.comtrade.service.KategorijaService;

@Controller
public class KategorijaControler {
	
	private KategorijaService kategorijaService;
	@Autowired
	public KategorijaControler(KategorijaService kategorijaService) {
		super();
		this.kategorijaService = kategorijaService;
	}
	
	@PostMapping("/kategorija/kreiraj")
	public String kreirajKategoriju(@ModelAttribute("kategorija")Kategorije kategorije, Model model) {
		kategorijaService.save(kategorije);
		return null;
		
	}
}
