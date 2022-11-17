package com.rest.webservices.restfulwebservices.controller.versioning;

public class V2Person {

	private Name personName;

	public V2Person(Name personName) {
		super();
		this.personName = personName;
	}

	public Name getPersonName() {
		return personName;
	}

	@Override
	public String toString() {
		return "V2Person [personName=" + personName + "]";
	}

}
