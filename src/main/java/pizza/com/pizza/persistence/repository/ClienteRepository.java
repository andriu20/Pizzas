package pizza.com.pizza.persistence.repository;

import org.springframework.data.repository.ListCrudRepository;

import pizza.com.pizza.persistence.entity.Cliente;

public interface ClienteRepository extends ListCrudRepository<Cliente, Integer> {

}
