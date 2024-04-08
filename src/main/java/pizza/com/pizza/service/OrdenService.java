package pizza.com.pizza.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pizza.com.pizza.persistence.entity.Cliente;
import pizza.com.pizza.persistence.entity.Operador;
import pizza.com.pizza.persistence.entity.OrdenEntity;
import pizza.com.pizza.persistence.repository.OrdenRepository;

@Service
public class OrdenService {

    private final OrdenRepository ordenRepository;

    @Autowired
    public OrdenService(OrdenRepository ordenRepository) {
        this.ordenRepository = ordenRepository;
    }

    public OrdenEntity crearOrden(OrdenEntity ordenEntity) {
        return this.ordenRepository.save(ordenEntity);
    }

    public List<OrdenEntity> obtenerOrdenes() {
        return this.ordenRepository.findAll();
    }

    public Optional<OrdenEntity> obtenerOrden(Integer id) {
        return this.ordenRepository.findById(id);
    }

    public List<OrdenEntity> obtenerOrdenUsuario(Cliente cliente) {
        return this.ordenRepository.findByIdCliente(cliente);
    }
    public List<OrdenEntity> obtenerOrdenesOperador(Operador operador) {
        return this.ordenRepository.findByIdOperador(operador);
    }
}
