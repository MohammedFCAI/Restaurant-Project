package com.mohamed.resturant.service.interfaces;

import com.mohamed.resturant.model.Category;

import java.util.List;
import java.util.NoSuchElementException;

public interface CategoryService {


    public Category addCategory(Category category) ;

    public Category updateCategory(Category category) ;


    public void deleteCategoryById(int id) ;

    public List<Category> getAllCategories();

    public Category getCategoryById(int categoryId) ;

    public void checkIfCategoryIsExistOrThrowException(int categoryId);
}
