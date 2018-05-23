package apicella.bersani.repository;

import javax.persistence.EntityManager;

import apicella.bersani.model.Responsabile;

public class ResponsabileRepository extends JpaRepository<Responsabile> {
	
	public ResponsabileRepository(EntityManager em) {
		super(em, Responsabile.class);
	}

	public Responsabile findByEmail(String email) {
		Responsabile result;
		try{
			result =  em.createQuery("FROM Responsabile r WHERE r.email = '" + email + "'",Responsabile.class).getSingleResult();
		}catch(Exception e)
		{
			result = null;
		}
		
		return result;
	}

}
