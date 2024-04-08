package pizza.com.pizza.controller;

import org.springframework.web.bind.annotation.RestController;

import pizza.com.pizza.core.Response;
import pizza.com.pizza.persistence.entity.IngredientesEntity;
import pizza.com.pizza.persistence.entity.PizzaEntity;
import pizza.com.pizza.service.IngredienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/ingredientes")
public class IngredienteController {

    private final IngredienteService ingredienteService;

    @Autowired
    public IngredienteController(IngredienteService ingredienteService) {
        this.ingredienteService = ingredienteService;
    }

    @PostMapping("/crearIngrediente")
    public ResponseEntity<Response<IngredientesEntity>> crearIngrediente(
            @RequestBody IngredientesEntity ingredientesEntity) {

        try {

            IngredientesEntity create = this.ingredienteService.crearIngrediente(ingredientesEntity);
            return Response.successResponse("Ingrediente creado con exito", create);

        } catch (Exception e) {
            System.out.println(e);
            return Response.errorResponse("Error al crear ingrediente", null);

        }
    }

}
