package com.gift.www.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ListUpdateRequestDto {
	
	private String giftName;
	private String giftBrand;
	private String giftCategory;
	private String giftPrice;
	private int giftSold;
	private String giftContent;
	
	@Builder
	public ListUpdateRequestDto(String giftName, String giftBrand, String giftCategory, 
			String giftPrice, int giftSold, String giftContent) {
		this.giftName = giftName;
		this.giftBrand = giftBrand;
		this.giftCategory = giftCategory;
		this.giftPrice = giftPrice;
		this.giftSold = giftSold;
		this.giftContent = giftContent;
	}
	
}
