package com.mohamed.resturant.controller;

import com.mohamed.resturant.model.Category;
import com.mohamed.resturant.model.Food;
import com.mohamed.resturant.service.imp.CategoryServiceImp;
import com.mohamed.resturant.service.interfaces.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foods")
public class FoodController {
    @Autowired
    private FoodService foodServiceImp;
    @Autowired
    private CategoryServiceImp categoryServiceImp;

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<Food> getAllFoods() {
        return foodServiceImp.getAllFoods();
    }

    @PostMapping("/add/category/{categoryId}")
    public ResponseEntity<?> addFood(@RequestBody Food food, @PathVariable int categoryId) {
        Category category = categoryServiceImp.getCategoryById(categoryId);
        // DEPENDENCY Injection....
        food.setCategory(category);
        return new ResponseEntity<>(foodServiceImp.addFood(food), HttpStatus.CREATED);
    }

    @GetMapping("/getById/{foodId}")
    public ResponseEntity<?> getFoodById(@PathVariable int foodId) {
        return new ResponseEntity<>(foodServiceImp.getFoodById(foodId), HttpStatus.ACCEPTED);
    }

    @PutMapping("/update/category/{categoryId}")
    public ResponseEntity<?> updateFood(@RequestBody Food food, @PathVariable int categoryId) {
        food.setCategory(categoryServiceImp.getCategoryById(categoryId));
        return new ResponseEntity<>(foodServiceImp.updateFood(food), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        foodServiceImp.deleteFoodById(id);
        return new ResponseEntity<>("Deleted. ", HttpStatus.ACCEPTED);
    }
}