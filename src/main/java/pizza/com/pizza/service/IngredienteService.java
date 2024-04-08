package pizza.com.pizza.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pizza.com.pizza.persistence.entity.IngredientesEntity;
import pizza.com.pizza.persistence.repository.IngredienteRepository;

@Service
public class IngredienteService {

    private final IngredienteRepository ingredienteRepository;

    @Autowired
    public IngredienteService(IngredienteRepository ingredienteRepository) {
        this.ingredienteRepository = ingredienteRepository;
    }

    public IngredientesEntity crearIngrediente(IngredientesEntity ingredientesEntity) {
        return this.ingredienteRepository.save(ingredientesEntity);
    }
}
