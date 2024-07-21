package com.example.haepari.dto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JoinDto {
    private String username;
    private String password;
    private String nickname;
    private String phone;
}
