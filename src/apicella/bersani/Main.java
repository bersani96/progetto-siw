package apicella.bersani;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import apicella.bersani.model.Azienda;
import apicella.bersani.model.Responsabile;

/**
 * Solo per testare la struttura del database.
 */
@Controller
public class Main {
	
	@RequestMapping("/")
	protected String showHomePage(@ModelAttribute("azienda") Azienda azienda, Model model) {
		if(azienda==null)
		{	azienda = new Azienda();
			model.addAttribute("azienda", azienda);
		}
		
		return "index";
	}
	
	@RequestMapping("/login")
	protected String showLoginPage(Model model) {
		model.addAttribute("responsabile", new Responsabile());
		return "login";
	}
	
	@RequestMapping("/nuova_pagina")
	public String nuovaPagina(Model model) {
		System.out.println(model.containsAttribute("responsabileLoggato"));
		return "nuova_pagina";
	}
	

}
