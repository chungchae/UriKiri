package com.example.haepari.Controller;

import com.example.haepari.Entity.Delivery;
import com.example.haepari.Entity.Request;
import com.example.haepari.Repository.RequestRepository;
import com.example.haepari.Service.DeliveryService;
import com.example.haepari.dto.DeliveryListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/request/delivery")
public class DeliveryController {
    private final DeliveryService deliveryService;
    private final RequestRepository requestRepository;

    @Autowired
    public DeliveryController(DeliveryService deliveryService, RequestRepository requestRepository) {
        this.deliveryService = deliveryService;
        this.requestRepository = requestRepository;
    }

    // Request 객체로 Delivery 리스트 조회
    @GetMapping("/{requestId}")
    public ResponseEntity<List> getDeliveryList(@PathVariable int requestId) {

        List<Delivery> dto = deliveryService.getDeliveryList(requestId);

        return ResponseEntity.ok(dto);
    }

    // Delivery 상태 업데이트
    @PutMapping("/accept/{id}")
    public void updateDeliveryStatus(@PathVariable int id) {
        deliveryService.updateDeliveryStatus(id);
    }

    // Delivery 삭제
    @DeleteMapping("/refuse/{id}")
    public void deleteDelivery(@PathVariable int id) {
        deliveryService.deleteDelivery(id);
    }
}
