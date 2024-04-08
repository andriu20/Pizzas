package pizza.com.pizza.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pizza.com.pizza.persistence.entity.PizzaEntity;
import pizza.com.pizza.persistence.repository.PizzaRepository;

@Service
public class PizzaService {

    private final PizzaRepository pizzaRepository;

    @Autowired
    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    public PizzaEntity crearPizza(PizzaEntity pizzaEntity) {
        return this.pizzaRepository.save(pizzaEntity);
    }

}
