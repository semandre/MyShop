package menu.app.service;

import menu.app.entity.Category;

import java.util.List;

public interface CategoryService {
    void save(Category category);
    List<Category> findAll();
    Category findOne(String name);
}
