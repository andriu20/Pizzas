package pizza.com.pizza.controller;

import org.springframework.web.bind.annotation.RestController;

import pizza.com.pizza.core.Response;
import pizza.com.pizza.persistence.entity.Administrador;
import pizza.com.pizza.persistence.entity.PizzaEntity;
import pizza.com.pizza.persistence.entity.UsuarioEntity;
import pizza.com.pizza.service.AdministradorService;
import pizza.com.pizza.service.PizzaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/pizzas")

public class PizzaController {

    private final PizzaService pizzaService;
    private final AdministradorService administradorService;

    @Autowired
    public PizzaController(PizzaService pizzaService, AdministradorService administradorService) {
        this.pizzaService = pizzaService;
        this.administradorService = administradorService;
    }

    @PostMapping("/crarPizza")

    public ResponseEntity<Response<PizzaEntity>> crearPizza(@RequestBody PizzaEntity pizzaEntity) {

        try {

            if (administradorService.exits(pizzaEntity.getAdministrador().getId())) {
                PizzaEntity create = this.pizzaService.crearPizza(pizzaEntity);
                return Response.successResponse("Pizza creada con exito", create);
            }
            return Response.errorResponse("Este usuario no puede crear pizza", null);

        } catch (Exception e) {
            System.out.println(e);
            return Response.errorResponse("Error al crear pizza", null);

        }
    }

}
