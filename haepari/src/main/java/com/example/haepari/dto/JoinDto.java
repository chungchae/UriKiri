package com.example.haepari.dto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class JoinDto {
    private String username;
    private String password;
    private String nickname;
    private String phone;
    private Map<String, List<Integer>> timeTable = new HashMap<>();

}
