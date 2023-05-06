package com.mohamed.resturant.repository;

import com.mohamed.resturant.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CategoryRepository extends JpaRepository<Category , Integer> {
}
