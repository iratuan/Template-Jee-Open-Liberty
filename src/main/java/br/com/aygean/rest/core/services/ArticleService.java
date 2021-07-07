package br.com.aygean.rest.core.services;

import br.com.aygean.rest.core.entities.Article;
import br.com.aygean.rest.core.repositories.ArticleRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RequestScoped
public class ArticleService {

    @Inject
    private ArticleRepository repository;

    public List<Article> findAll(){
        return repository.findAll();
    }

    public Article insert(Article article){
        article.setCreatedAt(LocalDate.now());
        return repository.save(article);
    }

    public Article show(Long id){
        Optional<Article> articlePersisted = Optional.ofNullable(repository.findBy(id));
        if(articlePersisted.isPresent()){
            return articlePersisted.get();
        }
        return null;
    }

    public Article update(Long id, Article article){
        Optional<Article> articlePersisted = Optional.ofNullable(repository.findBy(id));

        if(articlePersisted.isPresent()){
            Article articleUpdatable = articlePersisted.get();
            articleUpdatable.setId(article.getId());
            articleUpdatable.setAuthor(article.getAuthor());
            articleUpdatable.setActive(article.getActive());
            articleUpdatable.setCategories(article.getCategories());
            articleUpdatable.setTitle(article.getTitle());
            articleUpdatable.setResume(article.getResume());
            articleUpdatable.setContent(article.getContent());
            articleUpdatable.setUpdatedAt(LocalDate.now());
            return repository.save(articleUpdatable);
        }
        return null;
    }

    public void delete(Long id){
        Optional<Article> articlePersisted = Optional.ofNullable(repository.findBy(id));
        if(articlePersisted.isPresent()){
            repository.remove(articlePersisted.get());
        }
    }
}
