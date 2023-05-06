package com.mohamed.resturant.service.imp;

import com.mohamed.resturant.model.Food;
import com.mohamed.resturant.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FoodService implements com.mohamed.resturant.service.interfaces.FoodService {

    @Autowired
    private FoodRepository foodRepository;

    @Override
    public Food addFood(Food food  ) {
        food.setTotal(getTotalPriceForFoodAfterDiscount(food));
        return foodRepository.save(food);
    }

    @Override
    public Food updateFood(Food food) {
        checkIfFoodIsExistOrThrowException(food.getId());
        food.setTotal(getTotalPriceForFoodAfterDiscount(food));
        return foodRepository.save(food);
    }

    @Override
    public List<Food> getAllFoods() {
        return foodRepository.findAll();
    }

    @Override
    public void deleteFoodById(int id) {
        checkIfFoodIsExistOrThrowException(id);
        foodRepository.deleteById(id);
    }

    @Override
    public Food getFoodById(int foodId) {
        return foodRepository.findById(foodId).orElseThrow(
                () -> new NoSuchElementException("There Are No Food With Id = " + foodId));
    }
    @Override
    public void checkIfFoodIsExistOrThrowException(int foodId) {
        getFoodById(foodId);
    }

    private double getTotalPriceForFoodAfterDiscount(Food food) {
        return food.getPrice() - (food.getPrice() * (food.getDiscount() / 100));

    }


}
