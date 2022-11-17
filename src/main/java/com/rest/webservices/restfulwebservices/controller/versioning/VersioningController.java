package com.rest.webservices.restfulwebservices.controller.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningController {

	@GetMapping("/v1/person")
	public Person getPerson() {
		return new Person("First Last");
	}
}
