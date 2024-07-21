package com.example.haepari.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class RequestDto {
    private String store_address;
    private String destination_address;
    private boolean is_subscribed;
    private Timestamp destination_time;
    private Timestamp end_time;
    private String menu;
    private String content;
    private int distance;
    private int item_price;
    private int delivery_fee;
}
