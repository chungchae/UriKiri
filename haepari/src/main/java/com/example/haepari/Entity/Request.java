package com.example.haepari.Entity;

import jakarta.persistence.*;
import lombok.*;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@ToString
@NoArgsConstructor // 디폴트 생성자를 추가!
@Data
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String menu;

    @Column
    private String content;

    @Column
    private String store_address;

    @Column
    private String destination_address;

    @Column
    private boolean is_subscribed;

    @Column
    private Timestamp destination_time;

    @Column
    private Timestamp end_time;

    @Column
    private int distance;

    @Column
    private int item_price;

    @Column
    private int delivery_fee;


    // User와의 ManyToOne 관계 설정
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private User user;

    // Review와의 OneToOne 관계 설정
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Review review;


}

