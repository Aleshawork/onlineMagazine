package com.unproject.onlineMagazine.service;

import com.unproject.onlineMagazine.model.dao.Orders;
import com.unproject.onlineMagazine.model.dto.OrderDto;
import com.unproject.onlineMagazine.repository.OrdersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final OrdersRepo ordersRepo;

    @Autowired
    public OrderService(OrdersRepo ordersRepo) {
        this.ordersRepo = ordersRepo;
    }

    public List<OrderDto> getAllOrders(){
        List<Orders> orders = ordersRepo.getAll();
        return orders.stream().map(e->  new OrderDto(
                e.getClientId(),
                e.getStatus(),
                e.getProduct_id(),
                e.getCount(),
                e.getTransaction_id()))
                .collect(Collectors.toList());
    }

}
