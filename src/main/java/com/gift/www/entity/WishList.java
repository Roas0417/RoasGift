package com.gift.www.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class WishList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long wishListId;

	@Column(nullable = false)
	private Long userId;

	@Column(name = "giftId")
	private Long giftId;
	
	@ManyToOne
	@JoinColumn(name = "giftId", insertable = false, updatable = false)
	private ListEntity listEntity;

	@Builder
	public WishList(Long userId, Long giftId) {
		this.userId = userId;
		this.giftId = giftId;

	}
}
