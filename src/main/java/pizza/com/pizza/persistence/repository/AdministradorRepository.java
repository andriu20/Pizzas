package pizza.com.pizza.persistence.repository;

import java.util.Optional;

import org.springframework.data.repository.ListCrudRepository;

import pizza.com.pizza.persistence.entity.Administrador;



public interface AdministradorRepository extends ListCrudRepository<Administrador, Integer> {




}
