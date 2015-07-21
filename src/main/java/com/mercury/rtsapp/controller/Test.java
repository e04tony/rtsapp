package com.mercury.rtsapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mercury.rtsapp.domain.User;
import com.mercury.rtsapp.service.UserService;

@Controller
@RequestMapping("/")
public class Test {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/testtx", method = RequestMethod.GET)
	public String testTx(ModelMap model) {
		userService.deleteUserByEmail("1@a.com");
		User user = userService.findByEmail("1@a.cin");
		if(user == null) {
			model.addAttribute("message", "user is null");
		} else {
			model.addAttribute("message", "user is exist");
		}
		return "test/testtx";
	}
	

}
