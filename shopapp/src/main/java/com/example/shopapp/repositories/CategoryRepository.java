package com.example.shopapp.repositories;

import com.example.shopapp.Model.Category;
import com.example.shopapp.Model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
