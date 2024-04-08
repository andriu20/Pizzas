package pizza.com.pizza.controller;

import org.springframework.web.bind.annotation.RestController;

import pizza.com.pizza.core.Response;
import pizza.com.pizza.persistence.entity.Cliente;
import pizza.com.pizza.persistence.entity.Operador;
import pizza.com.pizza.persistence.entity.OrdenEntity;
import pizza.com.pizza.persistence.entity.UsuarioEntity;
import pizza.com.pizza.service.OrdenService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
            return Response.successResponse("orden creada con exito", create);

        } catch (Exception e) {
            System.out.println(e);
            return Response.errorResponse("Error al crear orden", null);

        }
    }

    @GetMapping("/obtenerOrdenes")
    public ResponseEntity<Response<List<OrdenEntity>>> obtenerOrdenes() {

        try {

            List<OrdenEntity> geto = this.ordenService
                    .obtenerOrdenes();
            return Response.successResponse("ordene listadas con exito", geto);

        } catch (Exception e) {
            System.out.println(e);
            return Response.errorResponse("Error al obtener ordenes", null);

        }
    }

    @GetMapping("/obtenerOrdenesCliente/{id}")
    public ResponseEntity<Response<List<OrdenEntity>>> obtenerOrdenesCliente(@PathVariable("id") int id) {

        try {

            Cliente c = new Cliente();
            c.setId(id);
            List<OrdenEntity> geto = this.ordenService
                    .obtenerOrdenUsuario(c);
            return Response.successResponse("ordene listadas con exito", geto);

        } catch (Exception e) {
            System.out.println(e);
            return Response.errorResponse("Error al obtener ordenes", null);

        }
    }

    @GetMapping("/obtenerOrdenesOperador/{id}")
    public ResponseEntity<Response<List<OrdenEntity>>> obtenerOrdenesOperador(@PathVariable("id") int id) {

        try {

            Operador c = new Operador();
            c.setId(id);
            List<OrdenEntity> geto = this.ordenService
                    .obtenerOrdenesOperador(c);
            return Response.successResponse("ordenes listadas con exito", geto);

        } catch (Exception e) {
            System.out.println(e);
            return Response.errorResponse("Error al obtener ordenes", null);

        }
    }

    @GetMapping("/obtenerOrden/{id}")
    public ResponseEntity<Response<OrdenEntity>> obtenerOreden(@PathVariable("id") int id) {

        try {

            Optional<OrdenEntity> geto = this.ordenService
                    .obtenerOrden(id);
            if (geto.isPresent()) {
                return Response.successResponse("ordenes listada con exito", geto.get());

            }
            return Response.successResponse("No se encontro información con este id", null);

        } catch (Exception e) {
            System.out.println(e);
            return Response.errorResponse("Error al obtener ordenes", null);

        }
    }

}
