package com.rest.webservices.restfulwebservices.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import com.rest.webservices.restfulwebservices.user.User;

@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<>();
	private static int count = 0;
	
	public List<User> findAll() {
		return users;
	}
	
	public User findOne(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id); 
		return users.stream().filter(predicate).findFirst().get();
	}
	
	public User save(User user) {
		user.setId(count++);
		users.add(user);
		return user;
	}
	
}
