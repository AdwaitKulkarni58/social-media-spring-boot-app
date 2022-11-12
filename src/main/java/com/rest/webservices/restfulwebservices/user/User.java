package com.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;

public class User {

	// attributes of user
	
	private Integer id;
	private String name;
	private LocalDate birthdate;

	// constructor
	
	public User(Integer id, String name, LocalDate birthdate) {
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
	}

	// getters and setters for attributes
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	// toString method for attributes
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthdate=" + birthdate + "]";
	}

}
