package com.example.shopapp.controllers;

import com.example.shopapp.dtos.CategoryDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.DeleteExchange;

import java.util.List;
import java.util.Locale;

@RestController
//@Validated
@RequestMapping("${api.prefix}/categories")
public class CategoryController {
    // Hiện thị tất cả ca category
    @GetMapping("")
    public ResponseEntity<String> getAllCategories(
            @RequestParam("page") int page,
            @RequestParam("limit") int limit
    ) {
        return ResponseEntity.ok(String.format("page = %d ,limit = %d",page,limit));
    }
    @PostMapping("")
    public ResponseEntity<?> InsertCategory(
            @Validated @RequestBody CategoryDTO categoryDTO,
            BindingResult result
    ) {
        if(result.hasErrors()){
          List<String> errorMessages =  result.getFieldErrors().stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();
            return ResponseEntity.badRequest().body(errorMessages);
        }

        return ResponseEntity.ok("insert");
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> PutCategory(@PathVariable Integer id) {
        return ResponseEntity.ok("update"+ id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> DeleteCategory(@PathVariable Integer id) {
        return ResponseEntity.ok("delete" + id);
    }
}
