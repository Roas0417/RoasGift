package com.gift.www.dto;

import com.gift.www.entity.Role;
import com.gift.www.entity.User;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSaveRequestDto {
    private String name;
    private String email;
    private String thumbnail_image;
    
    public User toEntity() {
        return User.builder().name(name).email(email).thumbnail_image(thumbnail_image).role(Role.USER).build();

    }
}
