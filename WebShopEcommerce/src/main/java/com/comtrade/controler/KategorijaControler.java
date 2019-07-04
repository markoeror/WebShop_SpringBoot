package com.comtrade.controler;

import java.io.File;

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
		String name= kategorije.getNaziv();
		
		
		String path=System.getProperty("user.dir"); //vraca nam radni direktorij
		System.out.println(path);
		String uploadFile = path+"\\src\\main\\resources\\static\\images\\" + name+ "\\";
		
	//	String uploadFile = "C:\\Users\\Marko Eror\\eclipse-workspace\\webshop_satovi\\WebShopEcommerce\\src\\main\\resources\\static\\images\\" + name+ "\\";
	
		File f = new File(uploadFile);
		if (!f.exists()) {
			f.mkdir();
		}
		kategorijaService.save(kategorije);
		return "redirect:/admin";		
		}
	
	@PostMapping("/kategorija/{temp.id}")
		public String listaArtikalaKategorije(@ModelAttribute("kategorija1")int id) {
			Kategorije k= new Kategorije();
			k.setId(id);
			return null;			
		}
	
	
}
