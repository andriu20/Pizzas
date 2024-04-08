package pizza.com.pizza.persistence.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@Table(name = "Operador")
@Entity
@PrimaryKeyJoinColumn(name="id_usuario")
public class Operador extends UsuarioEntity {

    @OneToMany(mappedBy = "idUsuario")
    private List<HorarioEntity> list;

}
