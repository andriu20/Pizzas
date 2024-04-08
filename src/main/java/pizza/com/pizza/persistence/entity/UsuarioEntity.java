package pizza.com.pizza.persistence.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pizza.com.pizza.core.enums.TipoUsuario;

@Table(name = "Usuario")
@Entity
@Setter
@Getter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)

public class UsuarioEntity {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", nullable = false)
    private Integer id;

    @Column()
    private String nombres;

    @Column()
    private String apellidos;

    @Column()
    private String telefono;

    @Column(unique = true)
    private String email;

    @Column()
    private String sexo;

    @Column(unique = true)
    private String cedula;

    @Transient // Esta anotación indica a JPA que ignore este campo

    private String password;

    @Transient // Esta anotación indica a JPA que ignore este campo
    private TipoUsuario tipoUsuario;

    @Transient // Esta anotación indica a JPA que ignore este campo
    private LocalDateTime fechaIngreso;
    @Transient // Esta anotación indica a JPA que ignore este campo
    private LocalDateTime fechaNacimiento;
    @Transient // Esta anotación indica a JPA que ignore este campo
    private String direccion;
}
