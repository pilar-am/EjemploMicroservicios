package react.spring.empleado.v1.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "empleados")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String email;
    private String telefono;
    private String direccion;
    private double salario;
}
