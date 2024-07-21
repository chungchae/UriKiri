package com.example.haepari.Data.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @Column
    private String id;
    @Column
    private String password;
    @Column
    private String nickName;
    @Column
    private float star;
    @Column
    private int point;


}
