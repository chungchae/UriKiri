package com.example.haepari.Service;

import com.example.haepari.Entity.Request;
import com.example.haepari.Entity.Store;
import com.example.haepari.Entity.User;
import com.example.haepari.Repository.RequestRepository;
import com.example.haepari.Repository.StoreRepository;
import com.example.haepari.Repository.UserRepository;
import com.example.haepari.dto.RequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private StoreRepository storeRepository;

    public int saveRequest(RequestDto dto,String username){
        Request request = new Request();
        String store_address = dto.getStore_address();
        Store store = storeRepository.findByAddress(store_address);
        User user = userRepository.findByUsername(username);
        request.setStore(store);
        request.setDestination_address(dto.getDestination_address());
        request.set_subscribed(user.getIs_subscribed());
        request.setEnd_time(dto.getEnd_time());
        request.setDestination_time(dto.getDestination_time());
        request.setItem_price(dto.getItem_price());
        request.setDelivery_fee(dto.getDelivery_fee());
        request.setMenu(dto.getMenu());
        request.setContent(dto.getContent());

        requestRepository.save(request);

        return 1;
    }

}
