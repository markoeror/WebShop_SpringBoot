package com.comtrade.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.comtrade.entity.Artikal;
import com.comtrade.entity.Kategorije;
import com.comtrade.service.ArtikalService;
import com.comtrade.service.KategorijaService;

@Controller
public class ArtikalControler {

	private ArtikalService artikalService;
	private KategorijaService kategorijaService;
	@Autowired
	public ArtikalControler(ArtikalService artikalService, KategorijaService kategorijaService) {
		super();
		this.artikalService = artikalService;
		this.kategorijaService = kategorijaService;
	}
	
	@PostMapping("/artikal/kreiraj")
	public String kreirajArtikal(@ModelAttribute("artikal")Artikal artikal,@RequestParam("tipKategorije")int idKategorije) {
		Kategorije tipKategorije= new Kategorije();
		tipKategorije.setId(idKategorije);
		artikal.setKategorije(tipKategorije);
		artikalService.save(artikal);
		return "redirect:/admin";
	}
	
	
}