package com.gift.www.dto;

import com.gift.www.entity.ListEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ListSaveRequestDto {
	
	private String giftName;
	private String giftBrand;
	private String giftCategory;
	private String giftPrice;
	private String giftContent;
	
	@Builder
	public ListSaveRequestDto(String giftName, String giftBrand, String giftCategory, 
			String giftPrice, String giftContent) {
		this.giftName = giftName;
		this.giftBrand = giftBrand;
		this.giftCategory = giftCategory;
		this.giftPrice = giftPrice;
		this.giftContent = giftContent;
	}
	
	public ListEntity toEntity() {
		return ListEntity.builder()
				.giftName(giftName)
				.giftBrand(giftBrand)
				.giftCategory(giftCategory)
				.giftPrice(giftPrice)
				.giftContent(giftContent)
				.build();
	}
}
