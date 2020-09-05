package com.gift.www.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gift.www.dto.ImgReqResDto;
import com.gift.www.entity.ImgEntity;

public interface ImgRepository extends JpaRepository<ImgEntity, Long>{
	
	@Query("select img from ImgEntity img where giftId = :giftId")
	ImgReqResDto findByGiftId(@Param("giftId") Long giftId);
	
}
