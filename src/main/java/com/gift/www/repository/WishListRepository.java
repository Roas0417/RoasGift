package com.gift.www.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gift.www.entity.WishList;

public interface WishListRepository extends JpaRepository<WishList, Long> {

	@Query(value = "select wish_id from wish_list where user_id = :userId and gift_id = :giftId", nativeQuery = true)
	Long findWishId(@Param("userId") String userId, @Param("giftId") String giftId);
	
}
