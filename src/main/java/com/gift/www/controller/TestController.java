package com.gift.www.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.gift.www.service.KakaoLoginService;

@Controller
public class TestController {

	@Autowired
	private KakaoLoginService kakaoLoginService;

	@GetMapping("/index")
	public String index() {
		return "index";

	}

	@GetMapping("/lists")
	public String lists() {
		return "listing";
	}

	@RequestMapping(value = "/kakaologin")
	public String login(@RequestParam("code") String code, HttpSession session) {
	    String access_Token = kakaoLoginService.getAccessToken(code);
	    HashMap<String, Object> userInfo = kakaoLoginService.getUserInfo(access_Token);
	    System.out.println("login Controller : " + userInfo);
	    
	    //    클라이언트의 이메일이 존재할 때 세션에 해당 이메일과 토큰 등록
	    if (userInfo.get("email") != null) {
	        session.setAttribute("userId", userInfo.get("email"));
	        session.setAttribute("access_Token", access_Token);
	    }
	    return "index";
}
}