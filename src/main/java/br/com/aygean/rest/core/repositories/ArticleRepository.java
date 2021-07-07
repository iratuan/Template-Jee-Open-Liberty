package br.com.aygean.rest.core.repositories;

import br.com.aygean.rest.core.entities.Article;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository(forEntity = Article.class)
public interface ArticleRepository extends EntityRepository<Article,Long> {
}
