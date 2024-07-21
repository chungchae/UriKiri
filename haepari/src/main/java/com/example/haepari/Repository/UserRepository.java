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
    Boolean existsByPassword(String password); // 비밀번호 중복 체크를 위한 메서드 추가


    @Transactional
    User save(User user);


}
