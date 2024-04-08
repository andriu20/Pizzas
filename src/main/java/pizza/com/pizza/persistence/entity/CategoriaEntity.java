package pizza.com.pizza.persistence.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "Categoria")
@Entity
@Setter
@Getter
@NoArgsConstructor
public class CategoriaEntity {

    public CategoriaEntity(Integer id) {
        this.idCategoria = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria", nullable = false)
    private Integer idCategoria;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private String disponible;

    @OneToMany(mappedBy = "idCategoria")
    private List<PizzaEntity> list;

}
