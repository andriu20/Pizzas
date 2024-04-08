package pizza.com.pizza.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
