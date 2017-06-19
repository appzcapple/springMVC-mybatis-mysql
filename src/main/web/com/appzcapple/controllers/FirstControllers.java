package com.appzcapple.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.appzcapple.models.User;
import com.appzcapple.repository.UserRepository;


@Controller
public class FirstControllers {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value = "/hello" , method = RequestMethod.GET)
	@ResponseBody
	public String hello() {
		User user = userRepository.getUserById(1);
		
		return "hello, " + user.getUserName() + "!";
	}
	
}
