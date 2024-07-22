package com.example.haepari.Repository;

import com.example.haepari.Entity.Delivery;
import com.example.haepari.Entity.Request;
import com.example.haepari.dto.DeliveryDto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Integer> {
    List<Delivery> findAllByRequest(Request request);
    @Transactional
    Delivery save(Delivery delivery);
}
