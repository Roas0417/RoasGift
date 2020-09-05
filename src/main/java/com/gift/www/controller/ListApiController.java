package com.gift.www.controller;

import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.gift.www.dto.ListResponseDto;
import com.gift.www.dto.ListSaveRequestDto;
import com.gift.www.dto.ListUpdateRequestDto;
import com.gift.www.service.ListService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
//등록, 수정, 조회
public class ListApiController {

	private final ListService listService;
	
	/*@PostMapping("/api/v1/gift")
	public Long save(@RequestBody ListSaveRequestDto requestDto, MultipartHttpServletRequest 
			multipartHttpServletRequest) throws Exception {
		return listService.save(requestDto, multipartHttpServletRequest);
	}*/
	//글 입력
	
	@PutMapping("/api/v1/gift/{giftId}")
	public Long update(@PathVariable Long giftId, @RequestBody ListUpdateRequestDto requestDto) {
		return listService.update(giftId, requestDto);
	}
	//수정
	
	@GetMapping("/api/v1/gift/{giftId}")
	public ListResponseDto findById(@PathVariable Long giftId) {
		return listService.findById(giftId);
	}
	//조회
	
	@DeleteMapping("/api/v1/gift/{giftId}")
	public Long delete(@PathVariable Long giftId) {
		listService.delete(giftId);
		
		return giftId;
	}
	
	/*@GetMapping("/api/v1/gift/{keyword}")
	public ListResponseDto findByGiftNameOrGiftBrandContaining(@PathVariable String keyword) {
		return listService.findByGiftNameOrGiftBrandContaining(search);
	}*/
}
