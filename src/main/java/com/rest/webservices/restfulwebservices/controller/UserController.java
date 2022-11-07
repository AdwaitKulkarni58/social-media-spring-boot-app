package com.rest.webservices.restfulwebservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rest.webservices.restfulwebservices.service.UserDaoService;
import com.rest.webservices.restfulwebservices.user.User;


@RestController
public class UserController {

	@Autowired
	private UserDaoService userDaoService;
	
	public UserController(UserDaoService userDaoService) {
		this.userDaoService = userDaoService;
	}

	@GetMapping(path = "/users")
	public List<User> getUsers() {
		return userDaoService.findAll(); 
	}
	
	@GetMapping(path = "/users/{id}")
	public User getUser(@PathVariable int id) {
		return userDaoService.findOne(id);
	}
	
//	@PostMapping(path = "/users")
//	public User 
	
}
