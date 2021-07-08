package br.com.aygean.rest.core.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "articles", schema = "restdb")
@NamedQuery(name = "Article.findAll", query = "SELECT a FROM Article a")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String slug;

    private String resume;

    private String content;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(
            name = "article_category",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    @JsonManagedReference
    private List<Category> categories;

    @ManyToOne
    private User author;

    private LocalDate createdAt;

    private LocalDate updatedAt;

    private LocalDate disabledAt;

    private Boolean active;

    @Override
    public String toString() {
        return "{" +
                "id:" + id +
                ", title:'" + title + '\'' +
                ", slug'" + slug + '\'' +
                ", resume:'" + resume + '\'' +
                ", content:'" + content + '\'' +
                ", author:" + author +
                ", createdAt:" + createdAt +
                ", updatedAt:" + updatedAt +
                ", disabledAt:" + disabledAt +
                ", active:" + active +
                '}';
    }
}


