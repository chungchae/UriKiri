package com.example.haepari.Repository;
import lombok.*;
import com.example.haepari.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUsername(String username);

    Boolean existsByUsername(String username);


    @Transactional
    User save(User user);


}
