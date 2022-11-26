package com.bsn.tasklist.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	@RequestMapping("/check")
	public String testMethod() {
		return "Working";
	}
}
