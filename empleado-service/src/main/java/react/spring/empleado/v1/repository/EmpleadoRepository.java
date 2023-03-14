package react.spring.empleado.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import react.spring.empleado.v1.entity.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado,Integer> {
}
