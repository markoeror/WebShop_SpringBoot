package com.comtrade.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.comtrade.entity.Kategorije;
import com.comtrade.service.AdminService;
import com.comtrade.service.KategorijaService;

@Controller
public class AdminControler {
	private AdminService adminService;
	private KategorijaService kategorijaService;
	@Autowired
	public AdminControler(AdminService adminService, KategorijaService kategorijaService) {
		super();
		this.adminService = adminService;
		this.kategorijaService = kategorijaService;
	}


	@GetMapping("/admin")
	public String prikaziAdminFormu(Model model) {
		Kategorije kategorija = new Kategorije();
		model.addAttribute("kategorija", kategorija);
		model.addAttribute("listaKategorija",kategorijaService.getKategorijeList());
		return "admin";
		
	}
	
	
}
