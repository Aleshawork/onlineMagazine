package com.unproject.onlineMagazine.service;

import com.unproject.onlineMagazine.model.dao.Orders;
import com.unproject.onlineMagazine.model.dto.OrderDto;
import com.unproject.onlineMagazine.repository.OrdersRepo;
import com.unproject.onlineMagazine.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final OrdersRepo ordersRepo;
    private final ProductRepo productRepo;

    @Autowired
    public OrderService(OrdersRepo ordersRepo, ProductRepo productRepo) {
        this.ordersRepo = ordersRepo;
        this.productRepo = productRepo;
    }

    public List<OrderDto> getAllOrders(){
        List<Orders> orders = ordersRepo.getAll();

        return orders.stream().map(e-> {
            double total_price= productRepo.getById(e.getProduct_id()).getPrice()*e.getCount();
                  return   new OrderDto(
                            e.getClientId(),
                            e.getStatus(),
                            e.getProduct_id(),
                            e.getCount(),
                            e.getTransaction_id(),
                            total_price);
                })
                .collect(Collectors.toList());
    }

}
