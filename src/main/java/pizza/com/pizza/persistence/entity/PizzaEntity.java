package pizza.com.pizza.persistence.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "Pizza")
@Entity
@Setter
@Getter
@NoArgsConstructor
public class PizzaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pizza", nullable = false)
    private Integer idPizza;

    @Column(nullable = false)
    private String nombre;

    @Column(columnDefinition = "DECIMAL(6,2)", nullable = false)
    private Double precio;

    @Column(nullable = false)
    private String disponible;

    @Column(columnDefinition = "DECIMAL(6,2)", nullable = false)
    private Double promocion;

    @Column(columnDefinition = "DECIMAL(6,2)", name = "valor_descuento", nullable = false)
    private Double valorDescuento;

    @Column(nullable = false)
    private String estado;

    @Column(name = "fecha_Creacion", nullable = false)
    private LocalDateTime fecha;

    @ManyToOne()
    @JsonIgnore

    private Administrador administrador;

    @ManyToOne()
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
    @JsonIgnore

    private CategoriaEntity idCategoria;

    @ManyToMany
    @JoinTable(name = "pizza_ingrediente", joinColumns = @JoinColumn(name = "pizza_id"), inverseJoinColumns = @JoinColumn(name = "ingrediente_id"))
    private List<IngredientesEntity> ingredientes;

}
