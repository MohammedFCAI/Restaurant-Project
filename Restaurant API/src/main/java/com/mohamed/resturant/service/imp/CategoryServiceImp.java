package com.mohamed.resturant.service.imp;

import com.mohamed.resturant.model.Category;
import com.mohamed.resturant.repository.CategoryRepository;
import com.mohamed.resturant.service.interfaces.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CategoryServiceImp implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);

    }

    @Override
    public Category updateCategory(Category category) {
        checkIfCategoryIsExistOrThrowException(category.getId());
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategoryById(int id) {
        checkIfCategoryIsExistOrThrowException(id);
        categoryRepository.deleteById(id);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(int categoryId) {

        return categoryRepository.findById(categoryId).orElseThrow(
                () -> new NoSuchElementException("There Are No Category With categoryId  = " + categoryId)
        );
    }

    @Override
    public void checkIfCategoryIsExistOrThrowException(int categoryId) {
        getCategoryById(categoryId);
    }
}
