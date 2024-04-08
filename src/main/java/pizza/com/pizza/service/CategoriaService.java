package pizza.com.pizza.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pizza.com.pizza.persistence.entity.CategoriaEntity;
import pizza.com.pizza.persistence.repository.CategoriaRepository;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public CategoriaEntity crearCategoria(CategoriaEntity categoriaEntity) {
        return this.categoriaRepository.save(categoriaEntity);
    }
}
