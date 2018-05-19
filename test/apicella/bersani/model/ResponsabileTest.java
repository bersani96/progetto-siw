package apicella.bersani.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import apicella.bersani.repository.ResponsabileRepository;

class ResponsabileTest {
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private EntityTransaction tx;
	private static ResponsabileRepository repo;
	
	@BeforeAll
	public static void init()
	{
		emf = Persistence.createEntityManagerFactory("progetto-siw-test-unit");
		em = emf.createEntityManager(); 
		repo = new ResponsabileRepository(em);
	}
	
	@AfterAll
	public static void close()
	{
		if(em!=null)
			em.close();
		if(emf!=null)
			emf.close();
	}
	
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
	public void test_persist_singleton() {
		tx = em.getTransaction();
		tx.begin();
		
		Centro centro = makeCentro();
		Responsabile singleton = new Responsabile();
		singleton.setEmail("singleton@singleton");
		singleton.setPassword("pwd");
		singleton.setCentro(centro);
		em.persist(singleton);
		
		List<Responsabile> result = repo.findAll();
		assertEquals(1,result.size());
		
		tx.commit();

	}
	
}

