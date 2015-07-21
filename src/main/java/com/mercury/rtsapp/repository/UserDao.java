package com.mercury.rtsapp.repository;

import java.util.List;

import javax.persistence.Query;

import com.mercury.rtsapp.domain.User;

public class UserDao extends GenericCRUDDao<User, Integer> {

	public UserDao() {
		setClazz(User.class);
	}

	@SuppressWarnings("unchecked")
	public User findByEmail(String email) {
		String jpql = "SELECT U FROM USERS U WHERE U.email = :user_email";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("user_email", email);
		List<User> results = (List<User>) query.getResultList();
		if (results == null || results.size() == 0) {
			return null;
		} else {
			return results.get(0);
		}
	}

	public void deleteByEmail(String email) {
		String jpql = "DELETE FROM USERS " + "WHERE email = :user_email";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("user_email", email);
		int result = query.executeUpdate();
		System.out.println("Rows affected: " + result);
	}

}
