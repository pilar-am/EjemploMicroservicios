package react.spring.empleado.v1.service;

import react.spring.empleado.v1.entity.Empleado;

import java.util.List;

public interface EmpleadoService {
    List<Empleado> getAllEmpleados();

    void saveEmpleado(Empleado empleado);

    Empleado getEmpleadoById(int id);

    void deleteEmpleado(int id);
}
