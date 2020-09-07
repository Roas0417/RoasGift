package com.gift.www.dto;

import com.gift.www.entity.WishList;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class WishListSaveRequestDto {

	private Long userId;
	private Long giftId;

	@Builder
	public WishListSaveRequestDto(Long userId, Long giftId) {
		this.userId = userId;
		this.giftId = giftId;
	}

	public WishList toEntity() {
		return WishList.builder().userId(userId).giftId(giftId).build();
	}
}
