package com.gift.www.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gift.www.dto.PaymentSaveRequestDto;
import com.gift.www.service.ListService;
import com.gift.www.service.PaymentService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class PaymentApiController {

	private final PaymentService paymentService;
	private final ListService listService;
	
	@PostMapping("api/payment")
	public Long save(@RequestBody PaymentSaveRequestDto paymentSaveRequestDto) {
		
		listService.sold(paymentSaveRequestDto.getGiftId());
		
		return paymentService.save(paymentSaveRequestDto);
		
	}
}
