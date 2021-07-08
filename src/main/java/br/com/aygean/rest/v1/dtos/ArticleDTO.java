package br.com.aygean.rest.v1.dtos;

import br.com.aygean.rest.core.entities.Article;
import br.com.aygean.rest.core.entities.Category;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class ArticleDTO implements Serializable {

    private Long id;

    private String title;

    private String slug;

    private String resume;

    private String content;

    private List<CategoryDTO> categories;

    private UserDTO author = null;

    private LocalDate createdAt;

    private LocalDate updatedAt;

    private LocalDate disabledAt;

    private Boolean active;
    
    private final CategoryDTO categoryDTO = null;
    

    public ArticleDTO(Article article) {
        this.id = (Long)  article.getId();
        this.title = article.getTitle();
        this.slug = article.getSlug();
        this.resume = article.getResume();
        this.content = article.getContent();
        if(article.getAuthor() != null){
            this.author = new UserDTO(article.getAuthor());
        }
        this.createdAt = article.getCreatedAt();
        this.updatedAt = article.getUpdatedAt();
        this.disabledAt = article.getDisabledAt();
        this.active = article.getActive();
        if (!article.getCategories().isEmpty()) {
            for (Category category : article.getCategories()) {
                CategoryDTO categoryDTO = new CategoryDTO(category);
                this.categories.add(categoryDTO);
            }
        }
    }
}
