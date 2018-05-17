package apicella.bersani.repository;

import java.util.List;

/**
 * Interfaccia per le operazioni con il database.
 *
 * @param <T>
 */
public interface Repository<T> {
	public void save(T object);
	public T find(Long id);
	public List<T> findAll();
	public void update(T object);
	public void remove(T object);
}
