package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {
	@GetMapping("/map-register")
	public String registerMapping() {
		return "register";
	}
	@GetMapping("/map-login")
	public String loginMapping() {
		return "login";
	}
	@GetMapping("/map-songs")
	public String songMapping() {
		return "addsongs";
	}
	@GetMapping("/samplepayment")
	public String samplePayment() {
		return "samplepayment";
	}
	@GetMapping("/map-home")
	public String homepage() {
		return "index";
	}
	@GetMapping("/map-logout")
	public String logoutMapping() {
		return "login";
	}
}
