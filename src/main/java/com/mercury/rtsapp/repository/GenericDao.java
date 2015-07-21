package com.mercury.rtsapp.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.springframework.stereotype.Repository;

@Repository
public class GenericDao {
	@PersistenceContext
	protected EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public FullTextEntityManager getSearchManager() {
		return Search.getFullTextEntityManager(entityManager);
	}

}
