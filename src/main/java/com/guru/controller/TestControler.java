package com.guru.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestControler {
	
	@GetMapping
	public String test() {
		return "Hai ! its working...buddy";
	}
}
