package com.gift.www.dto;

import com.gift.www.entity.ImgEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ImgSaveRequestDto {
	
	private Long imgId;
	private Long giftId;
	private String originalFileName;
	private String storedFilePath;
	private Long fileSize;
	
	@Builder
	public ImgSaveRequestDto(Long imgId, Long giftId, String originalFileName, 
			String storedFilePath, Long fileSize) {
		this.imgId = imgId;
		this.giftId = giftId;
		this.originalFileName = originalFileName;
		this.storedFilePath = storedFilePath;
		this.fileSize = fileSize;
	}
	
	public ImgEntity toImgEntity() {
		return ImgEntity.builder()
				.giftId(giftId)
				.originalFileName(originalFileName)
				.storedFilePath(storedFilePath)
				.fileSize(fileSize)
				.build();
	}
}
