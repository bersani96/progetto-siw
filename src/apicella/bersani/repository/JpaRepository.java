package apicella.bersani.repository;

import java.util.List;

import javax.persistence.EntityManager;

import apicella.bersani.model.Responsabile;

public class JpaRepository<T> implements Repository<T> {

protected EntityManager em;
private Class myClass;
	
	/**
	 * Semplice repository per oggetti singoli.
	 * @param em EntityManager da usare
	 * @param c Class della classe da gestire
	 */
	public JpaRepository(EntityManager em, Class c) {
		this.em = em;
		this.myClass = c;
	}
	
	@Override
	public void save(T object) {
		em.persist(object);
		
	}

	@Override
	public T find(Long id) {
		return (T) em.find(myClass, id);
	}

	@Override
	public List<T> findAll() {
		return em.createQuery("FROM " + myClass.getName() + " t",myClass).getResultList();
	}

	@Override
	public void update(T object) {
		em.merge(object);
		
	}

	@Override
	public void remove(T object) {
		em.remove(object);
		
	}

}
