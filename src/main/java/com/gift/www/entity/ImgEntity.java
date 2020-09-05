package com.gift.www.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.gift.www.basetime.BaseTimeEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class ImgEntity extends BaseTimeEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long imgId;
	
	@Column(nullable = false)
	private Long giftId;
	
	@Column(nullable = false)
	private String originalFileName;
	
	@Column(nullable = false)
	private String storedFilePath;
	
	@Column(nullable = false)
	private Long fileSize;
	
	@Builder
	//빌더 패턴 클래스 생성
	//필드 값 변경의 목적과 의도를 명확히 하기 위함
	public ImgEntity(Long giftId, String originalFileName, String storedFilePath, Long fileSize) {
		this.giftId = giftId;
		this.originalFileName = originalFileName;
		this.storedFilePath = storedFilePath;
		this.fileSize = fileSize;
	}
}
