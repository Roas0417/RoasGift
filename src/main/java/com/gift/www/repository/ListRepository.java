package com.gift.www.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gift.www.entity.ListEntity;

public interface ListRepository extends JpaRepository<ListEntity, Long>{

	@Query("select p from ListEntity p order by p.id desc")
	List<ListEntity> findAllDesc();

	@Query(value = "select a.gift_id, a.created_date, a.modified_date, a.gift_brand, a.gift_category, a.gift_content, a.gift_name, a.gift_price, a.gift_sold, b.wish_list_id, b.gift_id from list_entity a left outer join (select wish_list_id, gift_id from wish_list where user_id = :userId) b on a.gift_id = b.gift_id order by a.gift_id desc", nativeQuery = true)
	List<ListEntity> findAllDescAtLogin(@Param("userId") Long userId);
	
}
