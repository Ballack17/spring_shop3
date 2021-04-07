package geekbrains.spring_shop.services;

import geekbrains.spring_shop.entities.Category;
import geekbrains.spring_shop.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return (List<Category>) categoryRepository.findAll();
    }
}
