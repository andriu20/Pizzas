package pizza.com.pizza.persistence.repository;

import org.springframework.data.repository.ListCrudRepository;

import pizza.com.pizza.persistence.entity.CredencialesEntity;


public interface CredentialRepository extends ListCrudRepository<CredencialesEntity, Integer> {


    CredencialesEntity findByUser(String user);
}
