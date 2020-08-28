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
//웬만해서 setter 쓰지 마라
@NoArgsConstructor
//기본 생성자 생성
@Entity
public class ListEntity extends BaseTimeEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//pk 생성 규칙
	//GenerationType.IDENTITY옵션을 추가해야만 auto_increment 실행
	private Long giftId;
	
	@Column(nullable = false)
	//굳이 선언하지 않아도 엔티티 클래스의 필드는 모두 컬럼이 된다.
	//기본값 외에 추가로 변경사항이 있는 경우 사용
	private String giftName;
	
	@Column(nullable = false)
	private String giftBrand;
	
	@Column(nullable = false)
	private String giftCategory;
	
	@Column(nullable = false)
	private String giftPrice;
	
	//@Column(nullable = false)
	//private String giftCode;
	
	//@Column(nullable = false)
	//private String giftImg;
	//content
	
	private int giftSold;
	
	private String giftContent;
	
	
	@Builder
	//빌더 패턴 클래스 생성
	//필드 값 변경의 목적과 의도를 명확히 하기 위함
	public ListEntity(String giftName, String giftBrand, String giftCategory, String giftPrice, 
			int giftSold, String giftContent) {
		this.giftName = giftName;
		this.giftBrand = giftBrand;
		this.giftCategory = giftCategory;
		this.giftPrice = giftPrice;
		this.giftSold = giftSold;
		this.giftContent = giftContent;
	}
	
	//엔티티 영속성
	//엔티티 객체의 값만 변경하면 별도로 query를 날릴 필요가 없다.
	//public void update(String title, String content) {
		//this.title = title;
		//this.content = content;
	//}
	
	public void update(String giftName, String giftBrand, String giftCategory, String giftPrice, 
			int giftSold, String giftContent) {
		this.giftName = giftName;
		this.giftBrand = giftBrand;
		this.giftCategory = giftCategory;
		this.giftPrice = giftPrice;
		this.giftSold = giftSold;
		this.giftContent = giftContent;
	}
}
