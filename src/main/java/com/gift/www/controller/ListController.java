package com.gift.www.controller;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.gift.www.dto.ListResponseDto;
import com.gift.www.service.ListService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class ListController {
	
	private final ListService listService;
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/gift/list")
	public String giftList(Model model) {
		model.addAttribute("listAll", listService.findAllDesc());
		
		return "listing";
	}
	
	@GetMapping("/gift/detail/{giftId}")
	public String giftDetail(@PathVariable Long giftId, Model model) {
		ListResponseDto dto = listService.findById(giftId);
		model.addAttribute("giftList", dto);
		return "listDetail";
	}
	
	@GetMapping("/gift/update/{giftId}")
	public String giftUpdate(@PathVariable Long giftId, Model model) {
		ListResponseDto dto = listService.findById(giftId);
		model.addAttribute("giftList", dto);
		return "listUpdate";
	}
	
	@GetMapping("/gift/write")
	public String giftWrite() {
		return "listWrite";
	}
	
	@GetMapping("/gift/search")
	public String findByKeyword(@RequestParam String keyword, Model model) {
		model.addAttribute("listAll", listService.findAllSearch(keyword));
		return "listing";
	}
}
