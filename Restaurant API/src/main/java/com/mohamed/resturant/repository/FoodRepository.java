package com.mohamed.resturant.repository;

import com.mohamed.resturant.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food , Integer> {
}
