package pizza.com.pizza.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "Credencial")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class CredencialesEntity {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_credencial", nullable = false)
    private Integer id;/// variable par el id de las credenciales

    @Column(unique = true, nullable = false)
    private String user; /// variable para el usuario

    @Column(nullable = false)
    private String password; /// variable para la contraseña

    @OneToOne()
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private UsuarioEntity idUsuario;

}
