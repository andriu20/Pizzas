package pizza.com.pizza.persistence.repository;

import org.springframework.data.repository.ListCrudRepository;

import pizza.com.pizza.persistence.entity.UsuarioEntity;

public interface UsuarioRepositoy  extends ListCrudRepository<UsuarioEntity, Integer>{

    
}
