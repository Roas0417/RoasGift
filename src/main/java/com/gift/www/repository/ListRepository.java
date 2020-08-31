package com.gift.www.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gift.www.entity.ListEntity;

public interface ListRepository extends JpaRepository<ListEntity, Long>{

	@Query("select p from ListEntity p order by p.id desc")
	List<ListEntity> findAllDesc();
	
	@Query("select p from ListEntity p where (p.giftName like %:keyword% OR p.giftBrand like %:keyword%) AND p.giftCategory like %:category% order by p.giftName desc")
	List<ListEntity> findAllSearch(@Param("keyword") String keyword, @Param("category") String category);
}
