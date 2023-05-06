package com.mohamed.resturant.controller;

import com.mohamed.resturant.model.Category;
import com.mohamed.resturant.service.imp.CategoryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/categories")
@RestController
public class CategoryController {
    @Autowired
    private CategoryServiceImp categoryServiceImp;

    @GetMapping("/getAll")
    public List<Category> getAll() {
        return categoryServiceImp.getAllCategories();
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Category addCategory(@RequestBody Category category) {
        return categoryServiceImp.addCategory(category);
    }

    @DeleteMapping("/deleteById/{categoryId}")
    public ResponseEntity<?> deleteById(@PathVariable int categoryId) {
        categoryServiceImp.deleteCategoryById(categoryId);
        return new ResponseEntity<>("Deleted ", HttpStatus.ACCEPTED);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateCategory(@RequestBody Category category) {

        return new ResponseEntity<>(categoryServiceImp.updateCategory(category), HttpStatus.ACCEPTED);
    }

}
