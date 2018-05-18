package apicella.bersani.repository;

import java.util.List;

import javax.persistence.EntityManager;

import apicella.bersani.model.Allievo;

public class AllievoJpaRepository implements Repository<Allievo> {

	private EntityManager em;
	
	public AllievoJpaRepository(EntityManager em) {
		this.em = em;
	}

	@Override
	public void save(Allievo object) {
		em.persist(object);
		
	}

	@Override
	public Allievo find(Long id) {
		return em.find(Allievo.class, id);
	}

	@Override
	public List<Allievo> findAll() {
		return em.createNamedQuery("findAllAllievi").getResultList();
	}

	@Override
	public void update(Allievo object) {
		em.merge(object);
		
	}

	@Override
	public void remove(Allievo object) {
		em.remove(object);
	}
	

}
