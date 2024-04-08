package pizza.com.pizza.service;

import java.util.List;
import java.util.Optional;

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

    public List<IngredientesEntity> obtenerIngredientes() {
        return this.ingredienteRepository.findAll();
    }

    public Optional<IngredientesEntity> obtenerIngrediente(int id) {
        return this.ingredienteRepository.findById(id);
    }
}
