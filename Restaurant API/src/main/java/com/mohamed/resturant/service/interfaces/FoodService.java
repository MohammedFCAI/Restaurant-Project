package com.mohamed.resturant.service.interfaces;

import com.mohamed.resturant.model.Food;

import java.util.List;
import java.util.NoSuchElementException;

public interface FoodService {

    public Food addFood(Food food);
    public Food updateFood(Food food);
    public List<Food>getAllFoods();

    public void deleteFoodById(int id );

    public Food getFoodById(int foodId) ;

    public void checkIfFoodIsExistOrThrowException(int foodId) ;



}
