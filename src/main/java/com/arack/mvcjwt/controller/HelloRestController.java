package com.arack.mvcjwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloRestController {

	@GetMapping("user")
	public String helloUser() {
		return "Hello User";
	}

	@GetMapping("admin")
	public String helloAdmin() {
		return "if you see this,mean the jwt is valid, and Authentication passed!";
	}

}