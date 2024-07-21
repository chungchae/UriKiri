package com.example.haepari.Repository;

import com.example.haepari.Entity.Request;
import com.example.haepari.Entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request,Integer> {

    List<Request> findAllByUser(User user);
    Request findById(int requestId);
    @Transactional
    Request save(Request request);

}
