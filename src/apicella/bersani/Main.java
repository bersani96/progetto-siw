package apicella.bersani;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Solo per testare la struttura del database.
 */
@Controller
public class Main {
	
	@RequestMapping("/")
	protected String showHomePage() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("progetto-siw-test-unit");
		EntityManager em = emf.createEntityManager();
		
		em.close();
		emf.close();
		
		return "index";
	}

}
