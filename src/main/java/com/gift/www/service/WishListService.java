package com.gift.www.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gift.www.dto.WishListDeleteRequestDto;
import com.gift.www.dto.WishListSaveRequestDto;
import com.gift.www.entity.ListEntity;
import com.gift.www.entity.WishList;
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
	@Transactional
	public Long findWishId(WishListSaveRequestDto wishListSaveRequestDto) {
		return wishListRepository.findWishId(wishListSaveRequestDto.getUserId(), wishListSaveRequestDto.getGiftId());
	}
	
	@Transactional
	public Long findWishId(WishListDeleteRequestDto wishListDeleteRequestDto) {
		return wishListRepository.findWishId(wishListDeleteRequestDto.getUserId(), wishListDeleteRequestDto.getGiftId());
	}
	
	public void delete(Long wishListId) {
		WishList wishList = wishListRepository.findById(wishListId)
				.orElseThrow(() -> new 
						IllegalArgumentException("해당 즐겨찾기가 없습니다. id = " + wishListId));
		
		wishListRepository.delete(wishList);
		
	}

}
