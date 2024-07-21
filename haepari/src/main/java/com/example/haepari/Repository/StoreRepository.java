package com.example.haepari.Repository;

import com.example.haepari.Entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store,Integer> {

    Store findByAddress(String address);
}
