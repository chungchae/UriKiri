package com.example.haepari.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Data
public class Cost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int item_cost; // 상품 가격

    @Column(nullable = false)
    private int delivery_cost; // 배달 가격

}