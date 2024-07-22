package com.example.haepari.Service;

import com.example.haepari.Entity.Delivery;
import com.example.haepari.Entity.Request;
import com.example.haepari.Entity.User;
import com.example.haepari.Repository.DeliveryRepository;
import com.example.haepari.Repository.RequestRepository;
import com.example.haepari.Repository.UserRepository;
import com.example.haepari.dto.DeliveryDto;
import com.example.haepari.dto.DeliveryListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class DeliveryService {
    @Autowired
    private DeliveryRepository deliveryRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RequestRepository requestRepository;

    public List getDeliveryList(int request_id) {
        Request request = requestRepository.findById(request_id);
        List<Delivery> deliveryList = deliveryRepository.findAllByRequest(request);

        List<DeliveryDto> newDeliveryList = new ArrayList<>();
        for (Delivery delivery : deliveryList) {
            User tempUser = userRepository.findById(Integer.parseInt(delivery.getPartner_id()));

            DeliveryDto newDeliveryDto = new DeliveryDto();
            newDeliveryDto.setPartner_score(tempUser.getScore());
            newDeliveryDto.setPartner_name(tempUser.getUsername());

            newDeliveryList.add(newDeliveryDto);
        }



        return newDeliveryList;
    }

    //Delivery 수락 : Delivery 아이디를 받아 상태 변경
    public void updateDeliveryStatus(int deliveryId) {
        Optional<Delivery> optionalDelivery = deliveryRepository.findById(deliveryId);
        if (optionalDelivery.isPresent()) {
            Delivery delivery = optionalDelivery.get();
            if ("0".equals(delivery.getStatus())) {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "이미 수락되었습니다");
            }
            delivery.setStatus("0"); // status를 0으로 변경
            deliveryRepository.save(delivery);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Delivery not found with id: " + deliveryId);
        }
    }

    //Delivery 거절 : Delivery 아이디를 받아 삭제
    public void deleteDelivery(int deliveryId) {
        if (deliveryRepository.existsById(deliveryId)) {
            deliveryRepository.deleteById(deliveryId);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Delivery not found with id: " + deliveryId);
        }
    }
}


