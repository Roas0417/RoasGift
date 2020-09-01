package com.gift.www.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gift.www.dto.WishListSaveRequestDto;
import com.gift.www.repository.WishListRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class WishListService {
	
	private final WishListRepository wishListRepository;
	
	//등록하고 id값 반환.
	@Transactional
	public Long save(WishListSaveRequestDto wishListSaveRequestDto) {
		return wishListRepository.save(wishListSaveRequestDto.toEntity()).getWishListId();
	}
	
//	public Long findWishId(String userId, String giftId) {
//		return wishListRepository.findWishId(userId, giftId);
//	}

}
