package com.example.haepari.Entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Data
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private int score;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Request request;

}

