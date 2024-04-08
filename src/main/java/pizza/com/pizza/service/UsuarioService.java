package pizza.com.pizza.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pizza.com.pizza.persistence.entity.UsuarioEntity;
import pizza.com.pizza.persistence.repository.UsuarioRepositoy;

@Service
public class UsuarioService {

    private final UsuarioRepositoy usuarioRepositoy;

    @Autowired
    public UsuarioService(UsuarioRepositoy user) {
        this.usuarioRepositoy = user;
    }

    /// crear usuario

    public UsuarioEntity createUser(UsuarioEntity usuarioEntity) {
        return this.usuarioRepositoy.save(usuarioEntity);
    }



}
