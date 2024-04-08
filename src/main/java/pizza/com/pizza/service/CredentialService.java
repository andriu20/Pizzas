package pizza.com.pizza.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pizza.com.pizza.persistence.entity.CredencialesEntity;
import pizza.com.pizza.persistence.repository.CredentialRepository;

@Service
public class CredentialService {

    private CredentialRepository credentialRepository;

    @Autowired
    public CredentialService(CredentialRepository repository) {
        this.credentialRepository = repository;
    }

    public void createUser(CredencialesEntity credencialesEntity) {
        this.credentialRepository.save(credencialesEntity);
    }

    public CredencialesEntity iniciarSesion(CredencialesEntity credencialesEntity) {
        CredencialesEntity existente = this.credentialRepository.findByUser(credencialesEntity.getUser());
        System.out.println(existente.getPassword() + "--_>");

        if (existente != null && existente.getUser() != null && existente.getPassword() != null &&
                existente.getUser().equals(credencialesEntity.getUser()) &&
                existente.getPassword().equals(credencialesEntity.getPassword())) {
            return existente;
        } else {
            System.out.println("llll");
            return null;
        }
    }

}
