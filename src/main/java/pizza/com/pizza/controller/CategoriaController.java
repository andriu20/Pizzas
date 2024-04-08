package pizza.com.pizza.controller;

import org.springframework.web.bind.annotation.RestController;

import pizza.com.pizza.core.Response;
import pizza.com.pizza.core.enums.TipoUsuario;
import pizza.com.pizza.persistence.entity.CategoriaEntity;
import pizza.com.pizza.persistence.entity.PizzaEntity;
import pizza.com.pizza.service.CategoriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

}
