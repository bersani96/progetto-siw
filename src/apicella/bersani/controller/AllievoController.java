package apicella.bersani.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import apicella.bersani.model.Allievo;
import apicella.bersani.repository.AllievoRepository;

@Controller
public class AllievoController {
	
	@RequestMapping("controllaAllievo")
	public String controllaAllievo(@RequestParam("email") String email, Model model) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("progetto-siw-unit");
		EntityManager em = emf.createEntityManager();
		AllievoRepository repo = new AllievoRepository(em);
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		Allievo cercato = repo.findByEmail(email);
		if(cercato==null)
		{
			System.out.println("Nessun allievo");
			model.addAttribute("messaggioErrore", "Non è presente nessun allievo con questa email.");
		}else
		{
			System.out.println("Allievo trovato");
			model.addAttribute("messaggio", "E' stato trovato il seguente allievo già registrato.");
			model.addAttribute("allievoCercato", cercato.toHtmlString());
		}
		
		return "controlloAllievoEsistente";
	}
}
