package com.example.haepari.Entity;
import jakarta.persistence.*;
import lombok.*;
@Entity
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Getter
@Setter
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String status; // 배달 상태

    @Column(nullable = false)
    private String partner_id; // 파트너 아이디

    // Request와의 ManyToOne 관계 설정
    @ManyToOne
    @JoinColumn(name = "request_id", nullable = false)
    private Request request;

    // User와의 ManyToOne 관계 설정
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
