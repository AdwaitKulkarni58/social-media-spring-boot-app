package com.rest.webservices.restfulwebservices.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import com.rest.webservices.restfulwebservices.user.User;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>(); // to store data locally
	private static int count = 1; // to increment the id automatically for new user

	// return all the users in the list

	public List<User> findAll() {
		return users;
	}

	// find the first user with the given id

	public User findOne(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		return users.stream().filter(predicate).findFirst().orElse(null);
	}

	// add a new user to the list

	public User save(User user) {
		user.setId(count++);
		users.add(user);
		return user;
	}

	// remove all the users from the list

	public void delete() {
		users.clear();
	}

	public void deleteUser(User user) {
		//
	}

}
