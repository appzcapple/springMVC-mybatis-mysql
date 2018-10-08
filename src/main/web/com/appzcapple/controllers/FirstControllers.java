package com.appzcapple.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.appzcapple.models.Car;
import com.appzcapple.models.User;
import com.appzcapple.repository.UserRepository;


@Controller
public class FirstControllers {
	
	@Autowired
	private Car car;
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value = "/username" , method = RequestMethod.GET)
	@ResponseBody
	public String hell(HttpServletRequest req) {
		System.out.println(car.getColor());
		System.out.println(car.getMaxSpeed());
		System.out.println("servlet");
		
		return "hello";
	
	}
	
	@RequestMapping(value = "/hello" , method = RequestMethod.GET)
	@ResponseBody
	public User hello(HttpServletRequest req) {
		
		User user = userRepository.getUserById(1);
		
//		return "hello, " + user.getUserName() + "!";
		return user;
	}
	
}
