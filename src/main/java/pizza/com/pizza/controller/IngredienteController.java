package pizza.com.pizza.controller;

import org.springframework.web.bind.annotation.RestController;

import pizza.com.pizza.core.Response;
import pizza.com.pizza.persistence.entity.IngredientesEntity;
import pizza.com.pizza.service.IngredienteService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/obtenerIngredientes")
    public ResponseEntity<Response<List<IngredientesEntity>>> obtenerOrdenes() {

        try {

            List<IngredientesEntity> geto = this.ingredienteService
                    .obtenerIngredientes();
            return Response.successResponse("Ingredientes listadas con exito", geto);

        } catch (Exception e) {
            System.out.println(e);
            return Response.errorResponse("Error al obtener Ingredientes", null);

        }
    }

    @GetMapping("/obtenerIngrediente/{id}")
    public ResponseEntity<Response<IngredientesEntity>> obtenerOreden(@PathVariable("id") int id) {

        try {

            Optional<IngredientesEntity> geto = this.ingredienteService
                    .obtenerIngrediente(id);
            if (geto.isPresent()) {
                return Response.successResponse("Ingredinente listado con exito", geto.get());

            }
            return Response.successResponse("No se encontro información con este id", null);

        } catch (Exception e) {
            System.out.println(e);
            return Response.errorResponse("Error al obtener Ingredinente", null);

        }
    }

}
