package apicella.bersani.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import apicella.bersani.model.Responsabile;

@Controller
public class GeneralController {
	
	@RequestMapping("/firstCase")
	protected String prova1(HttpSession session, Model model) {
		
		Responsabile r=(Responsabile) session.getAttribute("responsabileLoggato");
		if (r==null) {
			/* vedere perchè all'indirizzamento crasha*/
			return "login";
		} else {
		return "prova1";
		}
	}
	
	@RequestMapping("/secondCase")
	public String prova2(HttpSession session, Model model) {
		
		Responsabile r=(Responsabile) session.getAttribute("responsabileLoggato");
		if (r==null) {
			return "login";
		}
		return "prova2";
		
	}
	
	@RequestMapping("/thirthCase")
	public String prova3(HttpSession session, Model model) {
		
		Responsabile r=(Responsabile) session.getAttribute("responsabileLoggato");
		if (r==null) {
			return "login";
		}
		return "prova3";
		
	}
	
	@RequestMapping("/fourthCase")
	public String prova4(HttpSession session, Model model) {
		
		Responsabile r=(Responsabile) session.getAttribute("responsabileLoggato");
		if (r==null) {
			return "login";
		}
		return "prova4";
		
	}
	
	@RequestMapping("/fivethCase")
	public String prova5(HttpSession session, Model model) {
		
		Responsabile r=(Responsabile) session.getAttribute("responsabileLoggato");
		if (r==null) {
			return "login";
		}
		return "prova5";
		
	}

}
