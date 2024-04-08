package pizza.com.pizza.persistence.repository;

import org.springframework.data.repository.ListCrudRepository;

import pizza.com.pizza.persistence.entity.PizzaEntity;

public interface PizzaRepository  extends ListCrudRepository<PizzaEntity, Integer>{
    
}
