package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/login-user")
	public String login() {
		return "user/login";
	}
	
	@GetMapping("/accessDenied")
	public String accessDenied() {
		return "user/accessDenied";
	}
}
