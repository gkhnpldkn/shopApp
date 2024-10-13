package com.gokhan.myshops.service.category;

import com.gokhan.myshops.exceptions.AlreadyExistException;
import com.gokhan.myshops.exceptions.ResourceNotFoundException;
import com.gokhan.myshops.model.Category;
import com.gokhan.myshops.repository.ICategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {
    private ICategoryRepository categoryRepository;
    @Override
    public Category getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Category Not Found!"));
        return category;

    }

    @Override
    public Category getCategoryByName(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category addCategory(Category category) {
        return Optional.of(category).filter(c ->!categoryRepository.existByName(c.getName()) )
                .map(categoryRepository ::save)
                .orElseThrow(() -> new AlreadyExistException(category.getName()+ " lready exist"));
    }

    @Override
    public Category updateCategory(Category category, Long id) {
        return Optional.ofNullable(getCategoryById(id)).map(oldCategory->{
            oldCategory.setName(category.getName());
            return categoryRepository.save(oldCategory);
        })
                .orElseThrow(()-> new ResourceNotFoundException("Category Not Found!"));
    }

    @Override
    public void deleteCategory(Long id) {
categoryRepository.findById(id).ifPresentOrElse(categoryRepository::delete, () -> {
    throw new ResourceNotFoundException("Category Not Found!");
});
    }
}
