package com.unproject.onlineMagazine.controller;

import com.unproject.onlineMagazine.model.dto.OrderDto;
import com.unproject.onlineMagazine.service.OrderService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("api/orders")
public class OrdresController {
    @Value("${web.main.url}")
    private String url;
    private final OrderService orderService;

    public OrdresController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/all")
    public String getAllOrdres(Model model){
        List<OrderDto> allOrders = orderService.getAllOrders();
        Map<Long, List<OrderDto>> collection = allOrders.stream()
                .collect(Collectors.groupingBy(OrderDto::getTransaction_id));


        model.addAttribute("collection",collection);
        model.addAttribute("mainurl",url);
        return "orders";
    }
}
