package com.example.haepari.Repository;

import com.example.haepari.Entity.AvailableTime;
import com.example.haepari.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface AvailableTimeRepository extends JpaRepository<AvailableTime,Integer> {
    @Transactional
    AvailableTime save(AvailableTime availableTime);

    List<AvailableTime> findAllByUser(User user);
}
