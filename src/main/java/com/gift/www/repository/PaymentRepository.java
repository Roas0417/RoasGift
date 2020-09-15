package com.gift.www.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gift.www.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
