package com.comtrade.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
		model.addAttribute("listKategorija",kategorijaService.getKategorijeList());
		return "admin";
		
	}
}
