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

@Setter
@Getter
@NoArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name="id_usuario")
public class Cliente extends UsuarioEntity {

    @Column(nullable = false)
    private String direccion;

    @Column(nullable = false)
    private LocalDateTime fechaNacimiento;

    @OneToMany(mappedBy = "idCliente")
    private List<OrdenEntity> idOrden;

}
