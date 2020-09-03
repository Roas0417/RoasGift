package com.gift.www.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.gift.www.service.KakaoLoginService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Controller
public class LoginController {

	private final KakaoLoginService kakaoLoginService;

	

	@GetMapping("/kakaologin")
	public String login(@RequestParam("code") String code, HttpSession session) {
		System.out.println("code : " + code);
		String access_Token = kakaoLoginService.getAccessToken(code);
		HashMap<String, Object> userInfo = kakaoLoginService.getUserInfo(access_Token);
		System.out.println("login Controller : " + userInfo);

		// 클라이언트의 이메일이 존재할 때 세션에 해당 이메일과 토큰 등록
		if (userInfo.get("email") != null) {
			session.setAttribute("userId", userInfo.get("userId"));
			session.setAttribute("userEmail", userInfo.get("email"));
			session.setAttribute("nickname", userInfo.get("nickname"));
			session.setAttribute("thumbnail_image", userInfo.get("thumbnail_image"));
			session.setAttribute("access_Token", access_Token);
		}
		return "index";
	}
}