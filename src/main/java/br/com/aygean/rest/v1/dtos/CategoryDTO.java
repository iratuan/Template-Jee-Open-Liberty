package br.com.aygean.rest.v1.dtos;

import br.com.aygean.rest.core.entities.Article;
import br.com.aygean.rest.core.entities.Category;

import java.io.Serializable;
import java.util.List;

public class CategoryDTO implements Serializable {

    private Long id;

    private String name;

    private String slug;

    public CategoryDTO(){
        System.out.println("OLAAAAAAAAAAAAA");
    }
}
