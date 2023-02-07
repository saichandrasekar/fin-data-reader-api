package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
	
	@GetMapping("/isalive")
	public @ResponseBody String isAlive() {
		return "Finance Data Reader API is up and running...!";
	}

}
