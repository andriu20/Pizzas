
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

@Entity
@Table(name = "Orden")
@Setter
@Getter
@NoArgsConstructor
public class OrdenEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_orden", nullable = false)
    private Integer idorden;

    @Column(name = "num_orden")
    private String numOrden;
    @Column()
    private String descripcion;
    @Column()
    private Integer descuento;
    @JoinColumn(columnDefinition = "Decimal(6,2)")
    private Double valorDescuento;

    @Column(name = "valor_pagar", columnDefinition = "Decimal(6,2)")
    private Double valorPagar;
    @Column()
    private String estado;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;
    @Column(name = "fecha_orden")
    private String fechaOrden;

    @ManyToOne()
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
     @JsonIgnore
    private Cliente idCliente;

    @ManyToMany
    @JoinTable(name = "orden_pizza", joinColumns = @JoinColumn(name = "id_orden"), inverseJoinColumns = @JoinColumn(name = "id_pizza"))
    private List<PizzaEntity> ordenes;

}
