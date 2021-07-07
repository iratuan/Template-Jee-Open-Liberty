package br.com.aygean.rest.core.repositories;

import br.com.aygean.rest.core.entities.Category;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository(forEntity = Category.class)
public interface CategoryRepository extends EntityRepository<Category,Long> {
}
