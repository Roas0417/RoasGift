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
    private String picture;
    
    public User toEntity() {
        return User.builder().name(name).email(email).picture(picture).role(Role.USER).build();

    }
}
