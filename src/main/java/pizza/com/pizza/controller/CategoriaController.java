package pizza.com.pizza.controller;

import org.springframework.web.bind.annotation.RestController;

import pizza.com.pizza.core.Response;
import pizza.com.pizza.persistence.entity.CategoriaEntity;
import pizza.com.pizza.service.CategoriaService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("api/categorias")

public class CategoriaController {

    private final CategoriaService categoriaService;

    @Autowired
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping("/crearCategoria")

    public ResponseEntity<Response<CategoriaEntity>> crearPizza(@RequestBody CategoriaEntity categoriaEntity) {
        try {
            CategoriaEntity create = this.categoriaService.crearCategoria(categoriaEntity);

            return Response.successResponse("Categoria creada con exito", create);

        } catch (Exception e) {
            System.out.println(e);
            return Response.errorResponse("Error al crear categoria", null);

        }
    }

    @GetMapping("/obtenerCategorias")
    public ResponseEntity<Response<List<CategoriaEntity>>> obtenerOrdenes() {

        try {

            List<CategoriaEntity> geto = this.categoriaService
                    .obtenerCategorias();
            return Response.successResponse("Categorias listadas con exito", geto);

        } catch (Exception e) {
            System.out.println(e);
            return Response.errorResponse("Error al obtener Categorias", null);

        }
    }

    @GetMapping("/obtenerCategoria/{id}")
    public ResponseEntity<Response<CategoriaEntity>> obtenerOreden(@PathVariable("id") int id) {

        try {

            Optional<CategoriaEntity> geto = this.categoriaService
                    .obtenerCategoria(id);
            if (geto.isPresent()) {
                return Response.successResponse("Categoria listada con exito", geto.get());

            }
            return Response.successResponse("No se encontro información con este id", null);

        } catch (Exception e) {
            System.out.println(e);
            return Response.errorResponse("Error al obtener ordenes", null);

        }
    }

}
