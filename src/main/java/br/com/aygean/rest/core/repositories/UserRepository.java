package br.com.aygean.rest.core.repositories;

import br.com.aygean.rest.core.entities.User;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository(forEntity = User.class)
public interface UserRepository extends EntityRepository<User,Long> {
}
