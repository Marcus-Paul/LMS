package com.lms.DAO;

import java.util.List;

import com.lms.EntityClasses.Category;

public interface CategoryDAO {
    void addCategory(Category category);
    Category getCategoryByID(int id);
    List<Category> getAllCategory();
    void updateCategory(Category category);
    void deleteCategory(Category category);
}
