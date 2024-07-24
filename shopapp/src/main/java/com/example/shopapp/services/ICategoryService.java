package com.example.shopapp.services;

import com.example.shopapp.Model.Category;
import com.example.shopapp.dtos.CategoryDTO;

import java.util.List;

public interface ICategoryService {
    Category createCategory(CategoryDTO category);
    Category getCategory(long id);

    List<Category> getAllCategories();

    Category updateCategory(long categoryId, CategoryDTO category);

    void deleteCategory(long id);
 }
