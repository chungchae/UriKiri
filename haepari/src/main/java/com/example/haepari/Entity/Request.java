package com.example.haepari.Entity;

import jakarta.persistence.*;
import lombok.*;


import java.sql.Timestamp;
import java.util.List;

@Entity
@AllArgsConstructor
@ToString
@NoArgsConstructor // 디폴트 생성자를 추가!
@Getter
@Setter
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String content;

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

    // User와의 ManyToOne 관계 설정
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Cost와의 OneToOne 관계 설정
    @OneToOne
    @JoinColumn(name = "cost_id", nullable = false)
    private Cost cost;

    // Review와의 OneToOne 관계 설정
    @OneToOne(mappedBy = "request")
    private Review review;

    // Delivery와의 OneToMany 관계 설정
    @OneToMany(mappedBy = "request")
    private List<Delivery> deliveries;
}

