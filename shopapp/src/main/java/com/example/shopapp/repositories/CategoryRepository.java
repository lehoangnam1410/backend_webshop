package com.example.shopapp.repositories;

import com.example.shopapp.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface CategoryRepository extends JpaRepository<Category, Long> {


}
