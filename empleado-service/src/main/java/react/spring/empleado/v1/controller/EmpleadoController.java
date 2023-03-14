package react.spring.empleado.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import react.spring.empleado.v1.entity.Empleado;
import react.spring.empleado.v1.service.EmpleadoService;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT,RequestMethod.DELETE})
public class EmpleadoController {

    @Autowired
    EmpleadoService empleadoService;

    @GetMapping("/empleados")
    public ResponseEntity<List<Empleado>> getAllEmpleados (){
        try{
            List<Empleado> empleados = empleadoService.getAllEmpleados();
            return new ResponseEntity<List<Empleado>>(empleados, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/empleados/{id}")
    public ResponseEntity<Empleado> getEmpleadoById(@PathVariable Integer id){
        Empleado empleado = empleadoService.getEmpleadoById(id);
        return new ResponseEntity<>(empleado, HttpStatus.OK);
    }

    @PostMapping("/empleados")
    public ResponseEntity<?> guardarEmpleado(@RequestBody Empleado empleado){
        try {
            empleadoService.saveEmpleado(empleado);
            return new ResponseEntity<>(empleado, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/empleados/{id}")
    public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable Integer id, @RequestBody Empleado empleado){
        try {
            Empleado empleado1 = empleadoService.getEmpleadoById(id);
            empleado1.setNombre(empleado.getNombre());
            empleado1.setEmail(empleado.getEmail());
            empleado1.setDireccion(empleado.getDireccion());
            empleado1.setTelefono(empleado.getTelefono());
            empleado1.setSalario(empleado.getSalario());
            empleadoService.saveEmpleado(empleado1);
            return new ResponseEntity<>(empleado1, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/empleados/{id}")
    public ResponseEntity<String> eliminarEmpleado(@PathVariable Integer id){
        empleadoService.deleteEmpleado(id);
        return new ResponseEntity<>("Empleado eliminado", HttpStatus.OK);
    }
}
