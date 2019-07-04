package com.comtrade.controler;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;

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

@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
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
	public String kreirajArtikal(@ModelAttribute("artikal") Artikal artikal, @RequestParam("idKat") int idKat,
			@RequestParam("tipKategorije") int idKategorije, @RequestParam("file") Part part) throws IOException {

		Kategorije tipKategorije = new Kategorije();
		tipKategorije.setId(idKategorije);
		artikal.setKategorije(tipKategorije);
		artikal.setKolicina(0);
		String nameKat = "";
		List<Kategorije> listC = kategorijaService.getKategorijeList();
		for (Kategorije c : listC) {
			if (c.getId() == (idKategorije)) {
				System.out.println(c.getId());
				nameKat = c.getNaziv();
			}
		}
		System.out.println("pokusaj kreiranja artikla " + artikal.getNaziv() + " u kategoriji " + nameKat);
		String fileName = GetFile(part);
		int a = fileName.lastIndexOf("\\");
		fileName = fileName.substring(a + 1);
		String filePath1 = new File("").getAbsolutePath();
		String path = System.getProperty("user.dir"); // vraca nam radni direktorijum
		System.out.println(path);
		String uploadFile = path + "\\src\\main\\resources\\static\\images\\" + nameKat + "\\";
		System.out.println(uploadFile);
		// String uploadFile="C:\\Users\\Marko
		// Eror\\eclipse-workspace\\webshop_satovi\\WebShopEcommerce\\src\\main\\resources\\static\\images\\"+nameKat+"\\";
		File f = new File(uploadFile);
		if (!f.exists()) {
			f.mkdir();
		}
		String name = uploadFile + fileName;
		System.out.println(name);
		part.write(name);
		System.out.println("snimljena slika " + fileName);
		artikal.setFileName(fileName);
		artikalService.save(artikal);
		return "redirect:/admin";
	}

	@PostMapping("/artikal/dodaj")
	public String dodajArtikal(@ModelAttribute("artikalDodaj") Artikal artikal,
			@RequestParam("artikalId") int artikalId) {
		int kolicina = artikal.getKolicina();
		Artikal artikal1 = artikalService.getArtikal(artikalId);

		kolicina += artikal1.getKolicina();
		artikal1.setKolicina(kolicina);
		artikalService.save(artikal1);
		return "redirect:/admin";

	}

	/*
	 * Metoda za vracanje naziva slike iz putanje slike koju ubacujemo za artikal u
	 * JAVI
	 */
	private String GetFile(Part part) {
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf("=") + 2, content.length() - 1);
			}
		}
		return null;
	}

}
