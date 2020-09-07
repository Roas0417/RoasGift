package com.gift.www.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String email;

	@Column
	private String thumbnail_image;

	@Enumerated(EnumType.STRING)
	@Column
	private Role role;

	@Builder
	public User(String name, String email, String thumbnail_image, Role role) {
		this.name = name;
		this.email = email;
		this.thumbnail_image = thumbnail_image;
		this.role = role;

	}

	public User update(String name, String thumbnail_image) {
		this.name = name;
		this.thumbnail_image = thumbnail_image;

		return this;

	}

	public String getRoleKey() {
		return this.role.getKey();

	}

}
