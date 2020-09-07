package com.gift.www.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gift.www.dto.WishListDeleteRequestDto;
import com.gift.www.dto.WishListSaveRequestDto;
import com.gift.www.service.WishListService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class WishListApiController {

	private final WishListService wishListService;

	@PostMapping("api/wish")
	public Long save(@RequestBody WishListSaveRequestDto wishListSaveRequestDto) {

		// dto로 이미 있는지 검색해서 없으면 save실행.
		if (wishListService.findWishId(wishListSaveRequestDto) != null) {
			System.out.println("이미 추가된 즐겨찾기.");
			return null;
		}

		return wishListService.save(wishListSaveRequestDto);

	}

	@DeleteMapping("api/wish")
	public Long delete(@RequestBody WishListDeleteRequestDto wishListDeleteRequestDto) {

		// dto로 이미 있는지 검색해서 있으면 delete 실행.
		Long wishListId = wishListService.findWishId(wishListDeleteRequestDto);

		if (wishListId != null) {
			wishListService.delete(wishListId);
			return wishListId;
		}
		System.out.println("없는 즐겨찾기.");
		return null;

	}
}
