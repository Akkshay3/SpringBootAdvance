package com.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Hello {

	@GetMapping("/1")
	public String helllo() {
		return "Hello Spring";
	}
}
