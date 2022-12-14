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

import com.rest.webservices.restfulwebservices.controller.exception.UserNotFoundException;
import com.rest.webservices.restfulwebservices.service.UserDaoService;
import com.rest.webservices.restfulwebservices.user.User;

import jakarta.validation.Valid;

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
		User user = userDaoService.findOne(id);
		if (user == null) {
			throw new UserNotFoundException("User with given i dnot found");
		}
		return userDaoService.findOne(id);
	}

	@PostMapping(path = "/users")
	public ResponseEntity<User> createNewUser(@Valid @RequestBody User user) {
		User savedUser = userDaoService.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri(); // get the current path, add "/{id}" to the end and replace the id with the
							// newly created user's id
		return ResponseEntity.created(location).build(); // return the correct status code when the user is created with
															// the new location
	}

	@DeleteMapping(path = "/users")
	public void removeAllUsers() {
		userDaoService.delete();
	}

	@DeleteMapping(path = "/users/{id}")
	public void removeOneUser(@PathVariable int id) {
		userDaoService.deleteUser(id);
	}

}
