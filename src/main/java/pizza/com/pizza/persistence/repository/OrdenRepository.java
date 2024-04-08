package pizza.com.pizza.persistence.repository;

import org.springframework.data.repository.ListCrudRepository;

import pizza.com.pizza.persistence.entity.OrdenEntity;

public interface OrdenRepository extends ListCrudRepository<OrdenEntity, Integer> {

}
