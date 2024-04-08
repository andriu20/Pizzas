package pizza.com.pizza.service;

import java.util.List;
import java.util.Optional;

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

    public List<CategoriaEntity> obtenerCategorias() {
        return this.categoriaRepository.findAll();
    }

    public Optional<CategoriaEntity> obtenerCategoria(Integer id) {
        return this.categoriaRepository.findById(id);
    }
}
