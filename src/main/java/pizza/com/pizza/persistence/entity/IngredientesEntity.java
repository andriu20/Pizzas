package pizza.com.pizza.persistence.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "Ingredientes")
@Entity
@Setter
@Getter
@NoArgsConstructor
public class IngredientesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ingrediente", nullable = false)
    private Integer idIngrediente;

    @Column()
    private String nombre;

    @Column()
    private String gramos;

    @Column()
    private String estado;
    @Column()
    private Boolean disponlibe;

    @Column(name = "fecha_aniade")
    private LocalDateTime fechaAniaade;

   

}
