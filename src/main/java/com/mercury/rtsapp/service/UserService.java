package com.mercury.rtsapp.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mercury.rtsapp.domain.User;
import com.mercury.rtsapp.repository.UserDao;
import com.mercury.rtsapp.repository.UserRoleDao;

@Service(value = "UserService")
public class UserService {
	private static final Logger logger = Logger.getLogger(UserService.class);

	@Autowired
	private UserDao userDao;
	@Autowired
	private UserRoleDao userRoleDao;

	@Transactional
	public void deleteUser(Integer userId) {
		userDao.deleteById(userId);
	}

	@Transactional
	public void deleteUserByEmail(String email) {
		userDao.deleteByEmail(email);
	}

	@Transactional
	public User findByEmail(String email) {
		return userDao.findByEmail(email);
	}

	@Transactional
	public User findById(Integer userId) {
		return userDao.findById(userId);
	}

	@Transactional
	public boolean insertUser(User user) throws Exception {
		boolean result = true;
		try {
			User checkUser = userDao.findByEmail(user.getEmail());
			if (checkUser != null) {
				result = false;
			} else {
				userDao.save(user);
			}
		} catch (Exception e) {
			logger.error("user service error", e);
			result = false;
		}
		logger.info("result: " + result);
		return result;
	}

	@Transactional
	public boolean insertOrUpdateUser(User user) throws Exception {
		boolean result = true;
		try {
			User checkUser = userDao.findByEmail(user.getEmail());
			if (checkUser != null) {
				result = false;
			} else {
				userDao.update(user);
			}
		} catch (Exception e) {
			logger.error("user service error", e);
			result = false;
		}
		logger.info("result: " + result);
		return result;
	}

}
