package apicella.bersani.repository;

import java.util.List;

import javax.persistence.EntityManager;

import apicella.bersani.model.Responsabile;

public class ResponsabileRepository implements Repository<Responsabile> {

private EntityManager em;
	
	public ResponsabileRepository(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public void save(Responsabile object) {
		em.persist(object);
		
	}

	@Override
	public Responsabile find(Long id) {
		return em.find(Responsabile.class, id);
	}

	@Override
	public List<Responsabile> findAll() {
		return em.createNamedQuery("findAllResponsabile").getResultList();
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

	@Override
	public void update(Responsabile object) {
		em.merge(object);
		
	}

	@Override
	public void remove(Responsabile object) {
		em.remove(object);
		
	}

}
