package com.gift.www.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long paymentIdx;

	@Column(nullable = false)
	private Long userId;

	@Column(name = "giftId")
	private Long giftId;

	private int amount;
	@CreatedDate
	private LocalDateTime checkDate;

	private boolean used;

	@Builder
	public Payment(Long userId, Long giftId, int amount, LocalDateTime checkDate, boolean used) {
		this.userId = userId;
		this.giftId = giftId;
		this.amount = amount;
		this.checkDate = LocalDateTime.now();
		this.used = false;

	}
}
