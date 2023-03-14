package react.spring.proveedor.v1.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "proveedores")
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String email;
    private String telefono;
    private String web;

}
