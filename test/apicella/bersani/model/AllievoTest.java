package apicella.bersani.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import apicella.bersani.repository.AllievoRepository;

class AllievoTest {
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private EntityTransaction tx;
	
	@BeforeClass
	public static void init()
	{
		emf = Persistence.createEntityManagerFactory("progetto-siw-test-unit");
		em = emf.createEntityManager(); 
	}
	
	@AfterClass
	public static void close()
	{
		if(em!=null)
			em.close();
		if(emf!=null)
			emf.close();
	}
	
	@Test
	public void test_singleton() throws Exception{
		emf = Persistence.createEntityManagerFactory("progetto-siw-test-unit");
		em = emf.createEntityManager(); 
		tx = em.getTransaction();
		AllievoRepository repo = new AllievoRepository(em);
		
		tx.begin();
		Allievo singleton = new Allievo();
		singleton.setNome("nome");
		singleton.setCognome("cognome");
		singleton.setEmail("nome@congome.com");
		singleton.setTelefono("123456789");
		singleton.setDataNascita(new Date(1996,01,01));
		singleton.setLuogoNascita("Roma");
		repo.save(singleton);
		tx.commit();
		
		List<Allievo> result = em.createNamedQuery("findAllAllievi").getResultList();
		assertEquals(1, result.size());
		if(em!=null)
			em.close();
		if(emf!=null)
			emf.close();
	}
		
}

