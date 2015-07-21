package com.mercury.rtsapp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_ROLE")
public class UserRole implements Serializable {

	private static final long serialVersionUID = 5274309746483987679L;
	@Id
	@GeneratedValue
	@Column(name = "USER_ROLE_ID")
	private Integer userRoleId;
	@Column(name = "ROLE")
	private String role;

	public UserRole() {
	}

	public UserRole(String role) {
		super();
		this.role = role;
	}

	public Integer getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
