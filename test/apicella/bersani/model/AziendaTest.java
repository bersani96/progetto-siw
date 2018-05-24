package apicella.bersani.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

public class AziendaTest {

	private static EntityManagerFactory emf;
	private static EntityManager em;
	private static EntityTransaction tx;
	private Centro makeCentro()
	{
		Centro centro = new Centro();
		centro.setNome("nomeSingleton");
		centro.setEmail("emailSingleon");
		centro.setIndirizzo("indirizzoSingleton");
		centro.setNumMax(1);
		centro.setTelefono("123456789");
		centro.setAttivita(new ArrayList<Attivita>());
		return centro;
	}
	
	@Test
	public void testAzienda() throws Exception{
		emf = Persistence.createEntityManagerFactory("progetto-siw-test-unit");
		em = emf.createEntityManager(); 
		tx = em.getTransaction();
		
		tx.begin();
		
		Responsabile r1= new Responsabile();
		r1.setCentro(makeCentro());
		r1.setEmail("ciao1");
		r1.setPassword("abxdgui	");

		List <Responsabile> lista= new ArrayList<>();
		lista.add(r1);
		
		Allievo a1= new Allievo();
		
		a1.setNome("nome");
		a1.setCognome("cognome");
		a1.setEmail("nome@congome.com");
		a1.setTelefono("123456789");
		a1.setDataNascita(new Date(1996,01,01));
		a1.setLuogoNascita("Roma");
		
		List<Allievo> allievi= new ArrayList<>();
		allievi.add(a1);
		
		
		Azienda singleton = new Azienda();
		singleton.setNome("azienda");
		singleton.setResponsabili(lista);
		singleton.setResponsabile(r1);
		singleton.setAllievi(allievi);
		
		
		em.persist(singleton);
		tx.commit();
		

		if(em!=null)
			em.close();
		if(emf!=null)
			emf.close();
	}
}
