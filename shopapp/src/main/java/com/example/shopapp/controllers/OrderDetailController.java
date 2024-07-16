package com.example.shopapp.controllers;

import com.example.shopapp.dtos.OrderDetailDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.prefix}/order_details")
public class OrderDetailController {
    @PostMapping("")
    public ResponseEntity<?> createOrderDetail(
            @Valid @RequestBody OrderDetailDTO dto


    ){
        return ResponseEntity.ok().body("ok");
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderDetail(
          @Valid  @PathVariable Long id) {
    return ResponseEntity.ok().body("ok");
    }
    @GetMapping("/order/{orderId}")
    public ResponseEntity<?> getOrderDetailByOrderId(
            @Valid  @PathVariable Long orderId
    ){
        return ResponseEntity.ok().body("ok");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrderDetail(
            @Valid @RequestBody OrderDetailDTO orderDetailDTO,
            @Valid @PathVariable Long id
    ){
        return ResponseEntity.ok().body("ok");
    }

}
