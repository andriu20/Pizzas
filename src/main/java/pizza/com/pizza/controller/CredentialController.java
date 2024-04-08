package pizza.com.pizza.controller;

import org.springframework.web.bind.annotation.RestController;

import pizza.com.pizza.core.Response;
import pizza.com.pizza.persistence.entity.CredencialesEntity;
import pizza.com.pizza.service.CredentialService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/sessions")

public class CredentialController {

    private final CredentialService credentialService;

    @Autowired
    public CredentialController(CredentialService credentialService) {
        this.credentialService = credentialService;
    }

    @PostMapping("/login")
    public ResponseEntity<Response<CredencialesEntity>> login(@RequestBody CredencialesEntity credencialesEntity) {
        try {
            CredencialesEntity c = this.credentialService.iniciarSesion(credencialesEntity);
            System.out.println(c);
            if (c == null) {
                throw new NullPointerException();
            }
            return Response.successResponse("Inicio de sesión exitoso", c);

        } catch (NullPointerException e) {
            // Manejar la excepción específica de NullPointerException
            return Response.errorResponse("Usuario y/o contraseña no son correctos", null);
        } catch (Exception e) {
            System.out.println(e);

            return Response.errorResponse("Error al iniciar sesión", null);
        }
    }
}
