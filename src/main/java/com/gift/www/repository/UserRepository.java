package com.gift.www.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gift.www.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmail(String email);
}
