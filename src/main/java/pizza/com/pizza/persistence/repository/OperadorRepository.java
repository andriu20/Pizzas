package pizza.com.pizza.persistence.repository;

import org.springframework.data.repository.ListCrudRepository;

import pizza.com.pizza.persistence.entity.Operador;

public interface OperadorRepository  extends ListCrudRepository<Operador, Integer>{
    
}
