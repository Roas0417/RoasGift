package com.gift.www.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gift.www.dto.PaymentSaveRequestDto;
import com.gift.www.repository.PaymentRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PaymentService {

	private final PaymentRepository paymentRepository;
	
	@Transactional
	public Long save(PaymentSaveRequestDto paymentSaveRequestDto) {
		
		return paymentRepository.save(paymentSaveRequestDto.toEntity()).getPaymentIdx();
		
	}
}
