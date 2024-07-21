package com.example.haepari.Repository;

import com.example.haepari.Entity.AvailableTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AvailableTimeRepository extends JpaRepository<AvailableTime,Integer> {
    @Transactional
    AvailableTime save(AvailableTime availableTime);
}
