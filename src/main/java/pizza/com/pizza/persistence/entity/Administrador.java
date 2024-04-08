package pizza.com.pizza.persistence.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="id_usuario")

public class Administrador extends UsuarioEntity {

    @Column(name = "fecha_ingreso")
    private LocalDateTime fechaIngreso;

    @OneToMany(mappedBy = "administrador") // nombre de la propiedad en PizzaEntity que referencia a AdministradorEntity
    private List<PizzaEntity> pizzas;

    

}

