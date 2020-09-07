package com.gift.www.controller;

import java.util.List;

import org.springframework.stereotype.Controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.gift.www.dto.ImgReqResDto;
import com.gift.www.dto.ListResponseDto;
import com.gift.www.dto.ListSaveRequestDto;
import com.gift.www.pagination.ListPagination;
import com.gift.www.repository.ListRepository;
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
	public String giftList(Model model, @RequestParam(defaultValue = "1") int page) {
		
		// 총 게시물 수 
	    int totalListCnt = listService.findAllCnt();
	    
	    // 생성인자로  총 게시물 수, 현재 페이지를 전달
	    ListPagination pagination = new ListPagination(totalListCnt, page);
	    
	    // DB select start index
	    int startIndex = pagination.getStartIndex();
	    // 페이지 당 보여지는 게시글의 최대 개수
	    int pageSize = pagination.getPageSize();
	    
	    //List<ListResponseDto> PageDto = listService.findListPaging(startIndex, pageSize);
		
		model.addAttribute("listAll", listService.findAllDesc(startIndex, pageSize));
		model.addAttribute("pagination", pagination);
		
		return "listing";
	}
	//전체상품
	
	@GetMapping("/gift/detail/{giftId}")
	public String giftDetail(@PathVariable Long giftId, Model model) {
		ListResponseDto dto = listService.findById(giftId);
		ImgReqResDto imgDto = listService.findByGiftId(giftId);
		
		model.addAttribute("giftList", dto);
		model.addAttribute("giftImg", imgDto);
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
