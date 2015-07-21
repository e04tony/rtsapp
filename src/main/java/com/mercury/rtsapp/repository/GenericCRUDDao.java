package com.mercury.rtsapp.repository;

import java.io.Serializable;
import java.util.List;

public class GenericCRUDDao<T extends Serializable, ID extends Serializable>
		extends GenericDao {
	private Class<T> clazz;

	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return this.entityManager.createQuery("from " + this.clazz.getName())
				.getResultList();
	}

	public T findById(ID id) {
		return (T) this.entityManager.find(clazz, id);
	}
	
	public void save(T entity) {
		this.entityManager.persist(entity);
	}
	
	public void update(T entity) {
		this.entityManager.merge(entity);
	}
	
	public void delete(T entity){
		this.entityManager.remove(entity);
	}
	
	public void deleteById (ID id) {
		T entity = (T)this.entityManager.find(clazz, id);
		this.entityManager.remove(entity);
	}

}
