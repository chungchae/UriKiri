package com.example.haepari.dto;

import lombok.Data;

@Data
public class RequestDto {
    private String store_address;
    private String destination_address;
    private boolean is_subscribed;
    private String destination_time;
    private String end_time;
    private String menu;
    private String content;
    private int distance;
}
