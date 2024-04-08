package pizza.com.pizza.controller;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pizza.com.pizza.core.Response;
import pizza.com.pizza.core.enums.TipoUsuario;
import pizza.com.pizza.persistence.entity.Administrador;
import pizza.com.pizza.persistence.entity.Cliente;
import pizza.com.pizza.persistence.entity.CredencialesEntity;
import pizza.com.pizza.persistence.entity.Operador;
import pizza.com.pizza.persistence.entity.UsuarioEntity;
import pizza.com.pizza.service.AdministradorService;
import pizza.com.pizza.service.ClienteService;
import pizza.com.pizza.service.CredentialService;
import pizza.com.pizza.service.OperadorService;
import pizza.com.pizza.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/users")
public class UsuarioController {
    /// Servicios
    private final CredentialService credentialService;
    private final AdministradorService administradorService;
    private final ClienteService clienteService;
    private final OperadorService operadorService;
    /// Entidades
    private CredencialesEntity credencialesEntity;
    private Administrador administradorEntity;
    private Cliente Cliente;
    private Operador operadorEntity;
    @SuppressWarnings("unused")
    private UsuarioEntity usuarioEntity;

    @Autowired
    public UsuarioController(UsuarioService usuarioService, CredentialService credentialService,
            AdministradorService administradorService,
            ClienteService clienteService, OperadorService operadorService) {
        this.credentialService = credentialService;
        this.administradorService = administradorService;
        this.clienteService = clienteService;
        this.operadorService = operadorService;
        usuarioEntity = new UsuarioEntity();

    }

    @PostMapping("/createUser")
    public ResponseEntity<Response<UsuarioEntity>> createUser(@RequestBody UsuarioEntity usuarioEntity) {
        try {

            UsuarioEntity c = tipoUsuario(usuarioEntity.getTipoUsuario(), usuarioEntity);
            return Response.successResponse("Usuario creado exitosamente", c);

        } catch (Exception e) {
            if (e.getCause() instanceof ConstraintViolationException) {
                return Response.errorResponse("la cedua y/o email ya se encuentran registrados", null);
            }
            return Response.errorResponse("Error al crear usuario", null);

        }
    }

    /// [addDataCredential] se añade la informacion de las credenciales y se crea el
    /// registro
    private void addDataCredential(UsuarioEntity usuario) {
        credencialesEntity = new CredencialesEntity();

        credencialesEntity.setUser(usuario.getEmail());
        credencialesEntity.setPassword(usuario.getPassword());
        credencialesEntity.setIdUsuario(usuario);
        this.credentialService.createUser(credencialesEntity);
    }

    /*
     * [tipoUsuario] segun el tipo de usuario se almacena en la tabla
     * correspondiente
     */
    private UsuarioEntity tipoUsuario(TipoUsuario tipo, UsuarioEntity usario) throws Exception {
        if (tipo.name().equals("ADMINISTRADOR"))
            return crearAdministador(usario);

        if (tipo.name().equals("OPERADOR"))

            return crearOperador(usario);

        if (tipo.name().equals("CLIENTE"))

            return crearCliente(usario);
        return usario;

    }

    private UsuarioEntity crearAdministador(UsuarioEntity uEntity) throws Exception {
        administradorEntity = new Administrador();
        administradorEntity.setNombres(uEntity.getNombres());
        administradorEntity.setApellidos(uEntity.getApellidos());
        administradorEntity.setCedula(uEntity.getCedula());
        administradorEntity.setSexo(uEntity.getSexo());
        administradorEntity.setEmail(uEntity.getEmail());
        administradorEntity.setTelefono(uEntity.getTelefono());
        administradorEntity.setPassword(uEntity.getPassword());
        administradorEntity.setFechaIngreso(uEntity.getFechaIngreso());
        administradorEntity.setId(uEntity.getId());

        Administrador ad = administradorService.crearAdminisrador(administradorEntity);
        addDataCredential(ad);
        return ad;
    }

    private UsuarioEntity crearCliente(UsuarioEntity uEntity) throws Exception {
        Cliente = new Cliente();
        Cliente.setNombres(uEntity.getNombres());
        Cliente.setApellidos(uEntity.getApellidos());
        Cliente.setCedula(uEntity.getCedula());
        Cliente.setSexo(uEntity.getSexo());
        Cliente.setEmail(uEntity.getEmail());
        Cliente.setTelefono(uEntity.getTelefono());
        Cliente.setPassword(uEntity.getPassword());
        Cliente.setFechaIngreso(uEntity.getFechaIngreso());
        Cliente.setDireccion(uEntity.getDireccion());
        Cliente.setFechaNacimiento(uEntity.getFechaNacimiento());
        Cliente.setId(uEntity.getId());
        Cliente ad = clienteService.crearCliente(Cliente);
        addDataCredential(ad);
        return ad;

    }

    private UsuarioEntity crearOperador(UsuarioEntity uEntity) throws Exception {
        operadorEntity = new Operador();

        operadorEntity.setNombres(uEntity.getNombres());
        operadorEntity.setApellidos(uEntity.getApellidos());
        operadorEntity.setCedula(uEntity.getCedula());
        operadorEntity.setSexo(uEntity.getSexo());
        operadorEntity.setEmail(uEntity.getEmail());
        operadorEntity.setTelefono(uEntity.getTelefono());
        operadorEntity.setPassword(uEntity.getPassword());
        operadorEntity.setFechaIngreso(uEntity.getFechaIngreso());
        operadorEntity.setId(uEntity.getId());
        Operador ad = operadorService.crearOperador(operadorEntity);
        addDataCredential(ad);
        return ad;

    }
}
