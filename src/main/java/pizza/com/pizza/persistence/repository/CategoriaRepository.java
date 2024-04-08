package pizza.com.pizza.persistence.repository;

import org.springframework.data.repository.ListCrudRepository;

import pizza.com.pizza.persistence.entity.CategoriaEntity;

public interface CategoriaRepository extends ListCrudRepository<CategoriaEntity, Integer>{
    
}
