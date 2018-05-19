package apicella.bersani.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

public class CentroTest {
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private static EntityTransaction tx;
	
	
	@Test
	public void testCentro() throws Exception{
		emf = Persistence.createEntityManagerFactory("progetto-siw-test-unit");
		em = emf.createEntityManager(); 
		tx = em.getTransaction();
		tx.begin();
		Centro singleton = new Centro();
		singleton.setNome("centro");
		singleton.setIndirizzo("via");
		singleton.setEmail("centro@centro.com");
		singleton.setTelefono("0000");
		singleton.setNumMax(20);
		Centro prova = new Centro();
		prova.setNome("prova");
		prova.setIndirizzo("prova");
		prova.setEmail("prova@centro.com");
		prova.setTelefono("1111");
		prova.setNumMax(33);
		em.persist(singleton);
		em.persist(prova);
		tx.commit();
		
		List<Centro> centri = em.createNamedQuery("findAllCentri").getResultList();
		assertEquals(2, centri.size());
		if(em!=null)
			em.close();
		if(emf!=null)
			emf.close();
	}
	
}
