package com.example.haepari.Entity;
import jakarta.persistence.*;
import lombok.*;


import java.sql.Timestamp;

@Entity
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Data
public class AvailableTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int day; // 요일 (0: 일요일, 1: 월요일, ...)

    @Column(nullable = false)
    private String available_time; // 활동 가능 시간

    // User와의 ManyToOne 관계 설정
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private User user;

}
