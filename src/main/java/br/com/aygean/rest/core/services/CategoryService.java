package br.com.aygean.rest.core.services;

import br.com.aygean.rest.core.entities.Article;
import br.com.aygean.rest.core.entities.Category;
import br.com.aygean.rest.core.repositories.CategoryRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequestScoped
public class CategoryService {

    @Inject
    private CategoryRepository repository;

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category insert(Category category) {
        return repository.save(category);
    }

    public Category get(Long id) {
        Optional<Category> categoryPersisted = Optional.ofNullable(repository.findBy(id));
        if (categoryPersisted.isPresent()) {
            return categoryPersisted.get();
        }
        return null;
    }

    public Category update(Long id, Category category) {
        Optional<Category> categoryPersisted = Optional.ofNullable(repository.findBy(id));

        if (categoryPersisted.isPresent()) {
            Category categoryUpdatable = categoryPersisted.get();
            categoryUpdatable.setId(category.getId());
            categoryUpdatable.setActive(category.getActive());
            categoryUpdatable.setName(category.getName());
            categoryUpdatable.setSlug(category.getSlug());
            return repository.save(categoryUpdatable);
        }
        return null;
    }

    public void delete(Long id) {
        Optional<Category> categoryPersisted = Optional.ofNullable(repository.findBy(id));
        if (categoryPersisted.isPresent()) {
            repository.remove(categoryPersisted.get());
        }
    }
}
