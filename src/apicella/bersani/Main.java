package apicella.bersani;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import apicella.bersani.model.Responsabile;
import apicella.bersani.repository.ResponsabileRepository;

/**
 * Solo per testare la struttura del database.
 */
@Controller
public class Main {
	
	@RequestMapping("/")
	protected String showHomePage(Model model) {
		return "index";
	}
	
	@RequestMapping("/login")
	protected String showLoginPage(Model model) {
		model.addAttribute("responsabile", new Responsabile());
		return "login";
	}
	
	

}
