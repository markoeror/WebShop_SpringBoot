package com.comtrade.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexControler {
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	
}
