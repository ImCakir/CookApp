package com.example.recipe.cooker.dto;

import lombok.Data;

@Data
public class UserDto {
    private String username;
    private String email;

    public UserDto(String username) {
        this.username = username;
    }
}
