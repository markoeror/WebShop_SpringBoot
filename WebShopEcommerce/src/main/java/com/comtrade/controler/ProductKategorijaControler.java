package com.comtrade.controler;

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
public class ProductKategorijaControler {
	private AdminService adminService;
	private KategorijaService kategorijaService;
	private ArtikalService artikalService;

	@Autowired
	public ProductKategorijaControler(AdminService adminService, KategorijaService kategorijaService,
			ArtikalService artikalService) {
		super();
		this.adminService = adminService;
		this.kategorijaService = kategorijaService;
		this.artikalService = artikalService;}
		
		
	/*	@GetMapping("/productKategorija/{idKat}")
		public String WebShopPrikaz(@PathVariable("idKat")int id,Model model) {
			
			  Kategorije kategorija = new Kategorije(); Artikal artikal= new Artikal();
			  Artikal artikalDodaj= new Artikal(); model.addAttribute("kategorija",
			  kategorija); model.addAttribute("artikal",artikal);
			  model.addAttribute("artikalDodaj",artikalDodaj);
			  model.addAttribute("listaKategorija",kategorijaService.getKategorijeList());
			  model.addAttribute("listaArtikala",artikalService.listaArtiklaZaKat(id));
		
		 * for(Artikal a:artikalService.listaArtikla()) { String
		 * naziv=a.getKategorije().getNaziv(); System.out.println(naziv); }
		 
			return "productKategorija";
		}
		*/
		
		
		
		
	

}
