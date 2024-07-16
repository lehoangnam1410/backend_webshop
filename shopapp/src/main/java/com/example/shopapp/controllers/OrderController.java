package com.example.shopapp.controllers;

import jakarta.validation.Valid;
import com.example.shopapp.dtos.OrderDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/orders")
public class OrderController {
    @PostMapping("")
    public ResponseEntity<?> createOrder(
            @Valid @RequestBody OrderDTO orderDTO,
            BindingResult result
    ) {
        try {
            if (result.hasErrors()) {
                List<String> errorMessages = result.getFieldErrors().stream()
                        .map(FieldError::getDefaultMessage)
                        .toList();
                return ResponseEntity.badRequest().body(errorMessages);
            }
            return ResponseEntity.ok("Create order successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/{user_id}")
    public ResponseEntity<?> getOrders(
            @PathVariable("user_id") Long user_id) {
        try {
            return ResponseEntity.ok("User ID");
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrder(
        @Valid @PathVariable long id,
        @Valid @RequestBody OrderDTO orderDTO
    ){
     return ResponseEntity.ok("Update order successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(
        @Valid  @PathVariable long id
    ){
        return ResponseEntity.ok("Delete order successfully");
    }
}
