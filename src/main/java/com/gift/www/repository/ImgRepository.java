package com.gift.www.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gift.www.entity.ImgEntity;

public interface ImgRepository extends JpaRepository<ImgEntity, Long>{
	
}
