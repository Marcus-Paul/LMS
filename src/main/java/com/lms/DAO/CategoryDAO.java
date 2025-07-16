package com.lms.DAO;

import com.lms.TableClassess.Category;

import java.util.List;

public interface CategoryDAO {
    void addCategory(Category category);
    void getCategoryByID(int id);
    List<Category> getAllCategory();
    void updateCategory(Category category);
    void deleteCategory(Category category);
}
