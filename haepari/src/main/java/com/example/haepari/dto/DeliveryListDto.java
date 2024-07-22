package com.example.haepari.dto;

import com.example.haepari.Entity.Delivery;
import lombok.Data;

import java.util.List;

@Data
public class DeliveryListDto {
    private List<DeliveryDto> DeliveryList;

    public void setDeliveryList(List<Delivery> deliveryList) {
    }
}
