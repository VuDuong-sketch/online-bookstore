package com.example.backend.controller;

import com.example.backend.dto.order.ItemRequest;
import com.example.backend.dto.order.OrderRequest;
import com.example.backend.service.OrderService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("")
    public ResponseEntity<Object> order(
            @RequestBody OrderRequest orderRequest,
            HttpServletRequest request
            ) {

        String role = request.getAttribute("role").toString();

        if (!role.equals("USER")) {
            return ResponseEntity.status(403).build();
        }

        String username = request.getAttribute("username").toString();
        List<ItemRequest> items = orderRequest.getItems();

        // create order in database
        try {
            orderService.order(username, items);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(409).build();
        }

        return ResponseEntity.status(200).build();
    }
}
