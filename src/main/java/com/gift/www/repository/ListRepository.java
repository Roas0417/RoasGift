package com.gift.www.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gift.www.entity.ListEntity;

public interface ListRepository extends JpaRepository<ListEntity, Long> {

	@Query("select p from ListEntity p where (p.giftName like %:keyword% OR p.giftBrand like %:keyword%) AND p.giftCategory like %:category% order by p.giftName desc")
	List<ListEntity> findAllSearch(@Param("keyword") String keyword, @Param("category") String category);

//	@Query(value = "select a.gift_id, a.created_date, a.modified_date, a.gift_brand, a.gift_category, a.gift_content, a.gift_name, a.gift_price, a.gift_sold, b.wish_list_id, b.gift_id from list_entity a left outer join (select wish_list_id, gift_id from wish_list where user_id = :userId) b on a.gift_id = b.gift_id order by a.gift_id desc", nativeQuery = true)
//	List<ListEntity> findAllDesc(@Param("userId") Long userId);

	@Query("select a, b from ListEntity a left outer join WishList b on a.giftId = b.giftId order by a.giftId desc")
	List<ListEntity> findAllDesc(@Param("userId") Long userId);
}
