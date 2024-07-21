package com.example.haepari.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String nickname;

    @Column
    private float score;

    @Column
    private int point;

    @Column
    private String phone;

    @Column
    private String location;

}
