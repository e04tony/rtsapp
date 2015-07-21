package com.mercury.rtsapp.security;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mercury.rtsapp.domain.UserRole;
import com.mercury.rtsapp.service.UserService;

@Service(value = "AccountSecurityService")
public class AccountSecurityService implements UserDetailsService {
	private static final Logger logger = Logger
			.getLogger(AccountSecurityService.class);

	@Autowired
	@Qualifier("UserService")
	private UserService userService;

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		logger.info("input username is: " + username);
		com.mercury.rtsapp.domain.User user = userService.findByEmail(username);
		List<GrantedAuthority> authorities = buildUserAuthority(user
				.getUserRoles());
		return buildUserForAuthentication(user, authorities);
	}

	private User buildUserForAuthentication(com.mercury.rtsapp.domain.User user,
			List<GrantedAuthority> authorities) {
		// TODO Auto-generated method stub
		return new User(user.getEmail(), user.getPassword(), user.getEnabled(),
				true, true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
		// Build user's authorities
		for (UserRole userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
		}
		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(
				setAuths);
		return Result;
	}

}
