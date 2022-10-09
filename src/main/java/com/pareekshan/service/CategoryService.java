package com.pareekshan.service;

import com.pareekshan.entity.quiz.Category;

import java.util.Set;

public interface CategoryService {

    public Category addCategory(Category category);
    public Category updateCategory(Category category);
    public Set<Category> getCategories();
    public Category getCategoryById(Long categoryId);
    public void deleteCategoryById(Long categoryId);
}
