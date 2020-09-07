package com.gift.www.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gift.www.entity.ListEntity;

public interface ListRepository extends JpaRepository<ListEntity, Long> {

//	@Query("select p from ListEntity p where (p.giftName like %:keyword% OR p.giftBrand like %:keyword%) AND p.giftCategory like %:category% order by p.giftName desc")
//	List<ListEntity> findAllSearch(@Param("keyword") String keyword, @Param("category") String category);

	@Query(value = "select * from list_entity a left outer join (select * from wish_list where user_id = :userId) b on a.gift_id = b.gift_id where (gift_name like %:keyword% OR gift_brand like %:keyword%) AND gift_category like %:category% order by gift_name desc", nativeQuery = true)
	List<ListEntity> findAllSearch(@Param("userId") Long userId, @Param("keyword") String keyword, @Param("category") String category);

	// 전체 조회
	@Query(value = "select * from list_entity a left outer join (select * from wish_list where user_id = :userId) b on a.gift_id = b.gift_id order by a.gift_id desc", nativeQuery = true)
	List<ListEntity> findAllDesc(@Param("userId") Long userId);

//	@Query("select a, b from ListEntity a left outer join WishList b on a.giftId = b.giftId order by a.giftId desc")
//	List<ListEntity> findAllDesc(@Param("userId") Long userId);
}
