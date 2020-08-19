package com.gift.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TestController {

	@GetMapping("/")
	public String hello() {
		return "hello";

	}



}
