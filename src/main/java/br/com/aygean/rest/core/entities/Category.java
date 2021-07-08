package br.com.aygean.rest.core.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "categories",  schema = "restdb")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String slug;

    private Boolean active;

    @ManyToMany(mappedBy = "categories",cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JsonBackReference
    private List<Article> articles;

    @Override
    public String toString() {
        return "{" +
                "id:" + id +
                ", name:'" + name + '\'' +
                ", slug:'" + slug + '\'' +
                ", active:" + active +
                '}';
    }
}
