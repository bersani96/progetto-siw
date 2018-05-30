package apicella.bersani.repository;

import javax.persistence.EntityManager;

import apicella.bersani.model.Allievo;
import apicella.bersani.model.Responsabile;

public class AllievoRepository extends JpaRepository<Allievo> {
	
	public AllievoRepository(EntityManager em) {
		super(em, Allievo.class);
	}

	public Allievo findByEmail(String email) {
		Allievo result;
		try{
			result =  em.createQuery("FROM Allievo a WHERE a.email = '" + email + "'",Allievo.class).getSingleResult();
		}catch(Exception e)
		{
			result = null;
		}
		
		return result;
	}

}
