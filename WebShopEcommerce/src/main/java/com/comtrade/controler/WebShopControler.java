package com.comtrade.controler;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.comtrade.entity.Artikal;
import com.comtrade.entity.Kategorije;
import com.comtrade.entity.Stavke;
import com.comtrade.entity.User;
import com.comtrade.service.AdminService;
import com.comtrade.service.ArtikalService;
import com.comtrade.service.KategorijaService;
import com.comtrade.service.StavkaService;



@Controller
public class WebShopControler {
	private AdminService adminService;
	private KategorijaService kategorijaService;
	private ArtikalService artikalService;	
	private StavkaService stavkaService;
	@Autowired
	public WebShopControler(AdminService adminService, KategorijaService kategorijaService,
			ArtikalService artikalService,StavkaService stavkaService) {
		super();
		this.adminService = adminService;
		this.kategorijaService = kategorijaService;
		this.artikalService = artikalService;
		this.stavkaService=stavkaService;
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
		return "productKategorija";
		}
	
	@PostMapping("/webshop/naruci")
	public String naruciArtikle(@RequestParam("idartikla")int idartikla,@RequestParam("kolicina")int kolicina,@RequestParam("cenaA")int cena,HttpSession sesija, Principal principal) {
		System.out.println(idartikla+" "+kolicina+" "+cena);
		Artikal artikal= new Artikal();
		artikal.setId(idartikla);
		try {			
			/* * OVDE U SESIJU UBACUJEMO ARRAYLISTU STAVKI, I SA SVAKIM LOGOVANJEM KAKO SE
			 * SALJE SESIJA TAKO CE SE PROSLEDJIVATI I LISTA STAVKI TJ KORPA */
			
			if(kolicina >= 1) {			
			Stavke stavke = new Stavke();
			stavke.setArtikal(artikal);
			stavke.setKolicina(kolicina);		
			ArrayList<Stavke> listaStavki = (ArrayList<Stavke>) sesija.getAttribute("listaStavki");
			ArrayList<Double> listaCena=(ArrayList<Double>) sesija.getAttribute("listaCena");
			Double korpa= (Double) sesija.getAttribute("korpa");
			
			if (listaStavki == null) {
				listaStavki = new ArrayList<Stavke>();
			}
			if (listaCena == null) {
				listaCena = new ArrayList<Double>();
			}
				listaStavki.add(stavke);
				listaCena.add((double) cena);
			if(korpa == null) {
				korpa=(double) 0.0;
			}
				korpa+=cena*kolicina;
				System.out.println(korpa);
				sesija.setAttribute("listaStavki", listaStavki);
				 sesija.setAttribute("korpa", korpa); 
				 sesija.setAttribute("listaCena", listaCena);
				 return "redirect:/webshop";
			} else {
				 return "redirect:/webshop";
			}
		} catch (Exception e) {
			e.printStackTrace();
			 return "redirect:/webshop";
		}		
	}
	
	@GetMapping("/webshop/kupovina")
	public String kupiArtikle(HttpSession sesija) {
		List<Stavke> listaStavki=(ArrayList<Stavke>) sesija.getAttribute("listaStavki");
		
		/* User user=(User) sesija.getAttribute("UlogovanKorisnik"); */
		String username="user";
		long id= 1;
		User user= new User();
		user.setUsername(username);
		user.setId(id);
		if(user!=null) {
    		ArrayList<Stavke>lista = (ArrayList<Stavke>)sesija.getAttribute("listaStavki");
    		stavkaService.insertKupovine(lista, user);
   
    		Double korpa=(Double)sesija.getAttribute("korpa");
    		korpa=0.0;
    		sesija.setAttribute("korpa", korpa);
    		System.out.println("Porudzbina uspesno kreirana");
    		return "redirect:/webshop";
    		
		/*}else {
			return "redirect:/webshop";
		}
		return "redirect:/webshop";
		*/
	}
		return  "redirect:/webshop";
	}
}
