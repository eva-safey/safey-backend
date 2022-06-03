package com.example.safey.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ExampleResource {

	@GetMapping("/hellouser")
	public String getUser()
	{
		return "Hello User";
	}

	@GetMapping("/helloadmin")
	public String getAdmin()
	{
		return "Hello Admin";
	}

}
