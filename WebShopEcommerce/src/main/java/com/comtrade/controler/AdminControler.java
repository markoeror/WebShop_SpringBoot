package com.comtrade.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.comtrade.entity.Artikal;
import com.comtrade.entity.Kategorije;
import com.comtrade.service.AdminService;
import com.comtrade.service.ArtikalService;
import com.comtrade.service.KategorijaService;

@Controller
public class AdminControler {
	private AdminService adminService;
	private KategorijaService kategorijaService;
	private ArtikalService artikalService;
	

	@Autowired
	public AdminControler(AdminService adminService, KategorijaService kategorijaService, ArtikalService artikalService) {
		super();
		this.adminService = adminService;
		this.kategorijaService = kategorijaService;
		this.artikalService = artikalService;
	}


	/* PRIKAZIVANJE ADMIN FORME */
	@GetMapping("/admin")
	public String prikaziAdminFormu(Model model) {
		Kategorije kategorija = new Kategorije();
		Kategorije kategorijaArtikala= new Kategorije();
		Artikal artikal= new Artikal();
		Artikal artikalDodaj= new Artikal();
		
		model.addAttribute("kategorija", kategorija);
		model.addAttribute("artikal",artikal);
		model.addAttribute("artikalDodaj",artikalDodaj);
		model.addAttribute("listaKategorija",kategorijaService.getKategorijeList());
		model.addAttribute("listaArtikala",artikalService.listaArtikla());
		model.addAttribute("kategorijaArtikala",kategorijaArtikala);
		return "admin";		
	}
	
	
}
