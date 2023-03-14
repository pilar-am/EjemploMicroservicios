package react.spring.empleado.v1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import react.spring.empleado.v1.entity.Empleado;
import react.spring.empleado.v1.repository.EmpleadoRepository;

import java.util.List;

@Service
public class EmpleadoServiceImp implements EmpleadoService {

    @Autowired
    EmpleadoRepository empleadoRepository;

    @Override
    public List<Empleado> getAllEmpleados() {
        return empleadoRepository.findAll();
    }

    @Override
    public void saveEmpleado(Empleado empleado) {
        empleadoRepository.save(empleado);
    }

    @Override
    public Empleado getEmpleadoById(int id) {
        return empleadoRepository.findById(id).get();
    }

    @Override
    public void deleteEmpleado(int id) {
        empleadoRepository.deleteById(id);
    }
}
