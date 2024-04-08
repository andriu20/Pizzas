package pizza.com.pizza.persistence.repository;

import org.springframework.data.repository.ListCrudRepository;

import pizza.com.pizza.persistence.entity.Cliente;
import pizza.com.pizza.persistence.entity.Operador;
import pizza.com.pizza.persistence.entity.OrdenEntity;
import java.util.List;

public interface OrdenRepository extends ListCrudRepository<OrdenEntity, Integer> {

    List<OrdenEntity> findByIdCliente(Cliente id);

    List<OrdenEntity> findByIdOperador(Operador idOperador);
}
