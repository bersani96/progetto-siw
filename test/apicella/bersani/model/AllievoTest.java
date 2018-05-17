package apicella.bersani.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import apicella.bersani.repository.AllievoRepository;

class AllievoTest {
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private EntityTransaction tx;
	private static AllievoRepository repo;
	
	@BeforeAll
	public static void init()
	{
		emf = Persistence.createEntityManagerFactory("progetto-siw-test-unit");
		em = emf.createEntityManager(); 
		repo = new AllievoRepository(em);
	}
	
	@AfterAll
	public static void close()
	{
		if(em!=null)
			em.close();
		if(emf!=null)
			emf.close();
	}
	
	@Test
	public void test_persist_singleton() {
		tx = em.getTransaction();
		
		tx.begin();
		Allievo singleton = new Allievo();
		singleton.setNome("nome");
		singleton.setCognome("cognome");
		singleton.setEmail("nome@congome.com");
		singleton.setTelefono("123456789");
		singleton.setDataNascita(new Date(1996,01,01));
		singleton.setLuogoNascita("Roma");
		repo.save(singleton);
		
		
		List<Allievo> result = repo.findAll();
		assertEquals(1, result.size());
		
		repo.remove(singleton);
		result = repo.findAll();
		tx.commit();
		assertEquals(0, result.size());
	}
	
	
	
		
}

