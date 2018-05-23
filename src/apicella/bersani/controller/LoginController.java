package apicella.bersani.controller;

import org.springframework.stereotype.Controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import apicella.bersani.model.Responsabile;
import apicella.bersani.repository.ResponsabileRepository;

@Controller
public class LoginController {

	@RequestMapping("/processLogin")
	public String processLogin(@ModelAttribute("responsabile") Responsabile responsabile, Model model)
	{
		String next;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("progetto-siw-unit");
		EntityManager em = emf.createEntityManager();
		ResponsabileRepository repo = new ResponsabileRepository(em);
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		Responsabile r = repo.findByEmail(responsabile.getEmail());
		tx.commit();
		
		if(r!=null && r.checkLogin(responsabile.getPassword()))
		{
			model.addAttribute("responsabile",r);
			next = "logged";
		}else
		{
			model.addAttribute("error","Email o password errati.");
			next = "login";
		}
		em.close();
		emf.close();
		
		return next;
		
	}
}
