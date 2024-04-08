package pizza.com.pizza.persistence.repository;

import org.springframework.data.repository.ListCrudRepository;

import pizza.com.pizza.persistence.entity.IngredientesEntity;

public interface IngredienteRepository extends ListCrudRepository<IngredientesEntity, Integer>{
    
}
