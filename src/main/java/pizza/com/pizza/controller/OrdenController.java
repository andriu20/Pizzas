package pizza.com.pizza.controller;

import org.springframework.web.bind.annotation.RestController;

import pizza.com.pizza.core.Response;
import pizza.com.pizza.persistence.entity.IngredientesEntity;
import pizza.com.pizza.persistence.entity.OrdenEntity;
import pizza.com.pizza.service.OrdenService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("api/orden")

public class OrdenController {

    private final OrdenService ordenService;

    @Autowired
    public OrdenController(OrdenService ordenService) {
        this.ordenService = ordenService;
    }

    @PostMapping("/crearOrden")
    public ResponseEntity<Response<OrdenEntity>> crearOrden(
            @RequestBody OrdenEntity ordenEntity) {

        try {

            OrdenEntity create = this.ordenService
                    .crearOrden(ordenEntity);
            return Response.successResponse("ordean cread con exito", create);

        } catch (Exception e) {
            System.out.println(e);
            return Response.errorResponse("Error al crear orden", null);

        }
    }
}
