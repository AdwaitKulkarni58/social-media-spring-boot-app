package com.rest.webservices.restfulwebservices.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	public List<User> findAlUsers() {
		return userDaoService.findAll();
	}

	@GetMapping(path = "/users/{id}")
	public User findOneUser(@PathVariable int id) {
		return userDaoService.findOne(id);
	}

	@PostMapping(path = "/users")
	public ResponseEntity<User> createNewUser(@RequestBody User user) {
		User savedUser = userDaoService.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping(path = "/users")
	public void removeAllUsers() {
		userDaoService.delete();
	}
}
