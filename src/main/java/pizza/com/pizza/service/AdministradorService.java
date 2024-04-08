package pizza.com.pizza.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pizza.com.pizza.persistence.entity.Administrador;
import pizza.com.pizza.persistence.repository.AdministradorRepository;

@Service
public class AdministradorService {

    private final AdministradorRepository administradorRepository;

    @Autowired
    public AdministradorService(AdministradorRepository administradorRepository) {
        this.administradorRepository = administradorRepository;
    }

    public Administrador crearAdminisrador(Administrador administradorEntity) {
      return  this.administradorRepository.save(administradorEntity);
    }


    public Boolean exits(Integer id){

      return this.administradorRepository.existsById(id);
    }

  
}
