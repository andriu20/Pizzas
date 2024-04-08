package pizza.com.pizza.service;

import org.springframework.stereotype.Service;

import pizza.com.pizza.persistence.entity.Operador;
import pizza.com.pizza.persistence.repository.OperadorRepository;

@Service
public class OperadorService {

    private final OperadorRepository operadorRepository;

    public OperadorService(OperadorRepository operadorRepository) {
        this.operadorRepository = operadorRepository;
    }

    public Operador crearOperador(Operador operadorEntity) {
       return this.operadorRepository.save(operadorEntity);
    }
}
