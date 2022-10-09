package com.pareekshan.service.impl;

import com.pareekshan.entity.quiz.Category;
import com.pareekshan.repository.CategoryRepository;
import com.pareekshan.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category addCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        Category newCategory = this.getCategoryById(category.getCid());
        newCategory.setDescription(category.getDescription());
        newCategory.setTitle(category.getTitle());
        return this.categoryRepository.save(newCategory);
    }

    @Override
    public Set<Category> getCategories() {
        return new LinkedHashSet<>(this.categoryRepository.findAll());
    }

    @Override
    public Category getCategoryById(Long categoryId) {
        return this.categoryRepository.findById(categoryId).get();
    }

    @Override
    public void deleteCategoryById(Long categoryId) {
        this.categoryRepository.deleteById(categoryId);
    }
}
