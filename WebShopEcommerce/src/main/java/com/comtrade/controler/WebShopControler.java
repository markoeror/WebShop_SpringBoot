package com.comtrade.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.comtrade.entity.Artikal;
import com.comtrade.entity.Kategorije;
import com.comtrade.service.AdminService;
import com.comtrade.service.ArtikalService;
import com.comtrade.service.KategorijaService;

@Controller
public class WebShopControler {
	private AdminService adminService;
	private KategorijaService kategorijaService;
	private ArtikalService artikalService;	
	@Autowired
	public WebShopControler(AdminService adminService, KategorijaService kategorijaService,
			ArtikalService artikalService) {
		super();
		this.adminService = adminService;
		this.kategorijaService = kategorijaService;
		this.artikalService = artikalService;
	}

	@GetMapping("/webshop")
	public String WebShopPrikaz(Model model) {
		
		  Kategorije kategorija = new Kategorije(); Artikal artikal= new Artikal();
		  Artikal artikalDodaj= new Artikal(); model.addAttribute("kategorija",
		  kategorija); model.addAttribute("artikal",artikal);
		  model.addAttribute("artikalDodaj",artikalDodaj);
		  model.addAttribute("listaKategorija",kategorijaService.getKategorijeList());
		  model.addAttribute("listaArtikala",artikalService.listaArtikla());
		 for(Artikal a:artikalService.listaArtikla()) {
			 String  naziv=a.getKategorije().getNaziv();
			 System.out.println(naziv);
		 }
		return "webshop";
		
	}
	
	@GetMapping("/webshop/kategorijaArtikli{id}")
	public String prikazKategorijeArtikli(@PathVariable("id")int id,Model model) {
			System.out.println(id);
			List<Artikal> listaArtikalaZaK= artikalService.listaArtiklaZaKat(id);
			for(Artikal a:listaArtikalaZaK) {
			System.out.println(a.getNaziv());}
			
			model.addAttribute("idKat",id);
			model.addAttribute("listaArtikala",listaArtikalaZaK);
			 model.addAttribute("listaKategorija",kategorijaService.getKategorijeList());
		return "webshop";
		}
	
}
