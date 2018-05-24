package apicella.bersani.model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import apicella.bersani.repository.JpaRepository;

class StrutturaTest {
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private static JpaRepository repo;
	private EntityTransaction tx;
	
	@BeforeAll
	public static void init()
	{
		emf = Persistence.createEntityManagerFactory("progetto-siw-test-unit");
		em = emf.createEntityManager(); 
		repo = new JpaRepository(em,Responsabile.class);
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
		tx=em.getTransaction();
		tx.begin();
		
		Centro c = makeCentro();
		Responsabile prova = new Responsabile();
		prova.setCentro(c);
		prova.setEmail("prova@prova.it");
		prova.setPassword("prova");
		repo.save(prova);
		tx.commit();
		
		assertEquals(1,repo.findAll().size());
	}
	
}

