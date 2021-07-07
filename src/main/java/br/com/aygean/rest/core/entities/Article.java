package br.com.aygean.rest.core.entities;

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

    @Transient
    private User author;

    private LocalDate createdAt;

    private LocalDate updatedAt;

    private LocalDate disabledAt;

    private Boolean active;
}


