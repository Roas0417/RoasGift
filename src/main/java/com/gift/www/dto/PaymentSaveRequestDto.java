package com.gift.www.dto;

import java.time.LocalDateTime;

import com.gift.www.entity.Payment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PaymentSaveRequestDto {

	private Long userId;
	private Long giftId;
	private int amount;
	private LocalDateTime checkDate;
	private boolean used;
	
	public Payment toEntity() {
		
		return Payment.builder().userId(userId).giftId(giftId).amount(amount).checkDate(LocalDateTime.now()).used(false).build();
	}
	
}
