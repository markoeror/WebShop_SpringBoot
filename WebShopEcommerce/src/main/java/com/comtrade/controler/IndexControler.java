package com.comtrade.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.comtrade.entity.Artikal;
import com.comtrade.entity.Kategorije;
import com.comtrade.service.AdminService;
import com.comtrade.service.ArtikalService;
import com.comtrade.service.KategorijaService;

@Controller
public class IndexControler {
	
	private AdminService adminService;
	private KategorijaService kategorijaService;
	private ArtikalService artikalService;	
	@Autowired
	public IndexControler(AdminService adminService, KategorijaService kategorijaService,
			ArtikalService artikalService) {
		super();
		this.adminService = adminService;
		this.kategorijaService = kategorijaService;
		this.artikalService = artikalService;
	}

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/index1")
		public String index1(Model model) {
		Kategorije kategorija = new Kategorije();
		Artikal artikal= new Artikal();
		Artikal artikalDodaj= new Artikal();
		model.addAttribute("kategorija", kategorija);
		model.addAttribute("artikal",artikal);
		model.addAttribute("artikalDodaj",artikalDodaj);
		model.addAttribute("listaKategorija",kategorijaService.getKategorijeList());
		model.addAttribute("listaArtikala",artikalService.listaArtikla());
			return"index1";
		}	
	
	@GetMapping("/index/kategorijaArtikli/{id}")
	public String prikazKategorijeArtikli(@PathVariable("id")int id) {
			System.out.println(id);
			List<Artikal> listaArtikala= artikalService.listaArtiklaZaKat(id);
			System.out.println(listaArtikala);
		
		return "redirect:/index1";
		
	}
}
