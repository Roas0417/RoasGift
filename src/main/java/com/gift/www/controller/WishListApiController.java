package com.gift.www.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gift.www.dto.WishListSaveRequestDto;
import com.gift.www.service.WishListService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class WishListApiController {

	private final WishListService wishListService;
	
	@PostMapping("api/wish")
	public Long save(@RequestBody WishListSaveRequestDto wishListSaveRequestDto) {
		return wishListService.save(wishListSaveRequestDto);
		
	}
	
	
}
