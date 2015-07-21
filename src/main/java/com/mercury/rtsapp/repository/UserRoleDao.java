package com.mercury.rtsapp.repository;

import org.springframework.stereotype.Repository;

import com.mercury.rtsapp.domain.UserRole;

@Repository
public class UserRoleDao extends GenericCRUDDao<UserRole, String> {
	public UserRoleDao() {
		setClazz(UserRole.class);
	}
}
