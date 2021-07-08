package br.com.aygean.rest.v1.dtos;

import br.com.aygean.rest.core.entities.Article;
import br.com.aygean.rest.core.entities.Category;

import java.util.List;

public class CategoryDTO {

    private Long id;

    private String name;

    private String slug;

    public CategoryDTO(Category category){
        this.id = category.getId();
        this.name = category.getName();
        this.slug = category.getSlug();
    }
}
