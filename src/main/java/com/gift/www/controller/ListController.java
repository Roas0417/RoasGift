package com.gift.www.controller;

import org.springframework.stereotype.Controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.gift.www.dto.ListResponseDto;
import com.gift.www.dto.ListSaveRequestDto;
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
	//메인
	
	@PostMapping("/gift/save")
	public String save(ListSaveRequestDto requestDto, MultipartHttpServletRequest 
			multipartHttpServletRequest) throws Exception {
		listService.save(requestDto, multipartHttpServletRequest);
		return "redirect:/gift/list";
	}
	//글 입력
	
	@GetMapping("/gift/list")
	public String giftList(Model model) {
		model.addAttribute("listAll", listService.findAllDesc());
		
		return "listing";
	}
	//전체상품
	
	@GetMapping("/gift/detail/{giftId}")
	public String giftDetail(@PathVariable Long giftId, Model model) {
		ListResponseDto dto = listService.findById(giftId);
		model.addAttribute("giftList", dto);
		return "listDetail";
	}
	//조회
	
	@GetMapping("/gift/update/{giftId}")
	public String giftUpdate(@PathVariable Long giftId, Model model) {
		ListResponseDto dto = listService.findById(giftId);
		model.addAttribute("giftList", dto);
		return "listUpdate";
	}
	//수정 입력페이지
	
	@GetMapping("/gift/write")
	public String giftWrite() {
		return "listWrite";
	}
	//글 생성페이지
	
	@GetMapping("/gift/search")
	public String findByKeyword(@RequestParam String keyword, @RequestParam String category, Model model) {
		model.addAttribute("listAll", listService.findAllSearch(keyword, category));
		return "listing";
	}
	//검색 목록 조회
}
