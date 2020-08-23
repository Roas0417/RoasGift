package com.gift.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TestController {

	@GetMapping("/index")
	public String index() {
		return "index";

	}
	
	@GetMapping("/lists")
	public String lists() {
		return "listing";
	}

}
