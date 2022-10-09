package com.pareekshan.controllers;

import com.pareekshan.entity.quiz.Category;
import com.pareekshan.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /* add new Category */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<?> addCategory(@RequestBody Category category){
        Category response = this.categoryService.addCategory(category);
        return ResponseEntity.ok(response);
    }
    /* get category by id */
    @RequestMapping(value = "/get/{categoryId}", method = RequestMethod.GET)
    public Category getCategoryById(@PathVariable("categoryId") Long categoryId){
        return this.categoryService.getCategoryById(categoryId);
    }

    /* get all categories */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResponseEntity<?> getCategories(){
        return ResponseEntity.ok(this.categoryService.getCategories());
    }

    /* update the categories */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Category updateCategory(@RequestBody Category category){
        return  this.categoryService.updateCategory(category);
    }

    /* delete category by categoryId */
    @RequestMapping(value = "/delete/{categoryId}", method = RequestMethod.DELETE)
    public String deleteCategory(@PathVariable("categoryId") Long categoryId){
        this.categoryService.deleteCategoryById(categoryId);
        return "Category Deleted Successfully";
    }
}
