package react.spring.proveedor.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import react.spring.proveedor.v1.entity.Proveedor;
import react.spring.proveedor.v1.service.ProveedorService;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT,RequestMethod.DELETE})
public class ProveedorController {

    @Autowired
    ProveedorService proveedorService;

    @GetMapping("/proveedores")
    public ResponseEntity<List<Proveedor>> getAllProveedores (){
        try{
            List<Proveedor> proveedores = proveedorService.getAllProveedores();
            return new ResponseEntity<List<Proveedor>>(proveedores, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/proveedores/{id}")
    public ResponseEntity<Proveedor> getProveedorById(@PathVariable Integer id){
        Proveedor proveedor = proveedorService.getProveedorById(id);
        return new ResponseEntity<>(proveedor, HttpStatus.OK);
    }

    @PostMapping("/proveedores")
    public ResponseEntity<?> guardarProveedor(@RequestBody Proveedor proveedor){
        try {
            proveedorService.saveProveedores(proveedor);
            return new ResponseEntity<>(proveedor, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/proveedores/{id}")
    public ResponseEntity<Proveedor> actualizarProveedor(@PathVariable Integer id, @RequestBody Proveedor proveedor){
        try {
            Proveedor proveedor1 = proveedorService.getProveedorById(id);
            proveedor1.setNombre(proveedor.getNombre());
            proveedor1.setEmail(proveedor.getEmail());
            proveedor1.setWeb(proveedor.getWeb());
            proveedor1.setTelefono(proveedor.getTelefono());

            proveedorService.saveProveedores(proveedor1);
            return new ResponseEntity<>(proveedor1, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/proveedores/{id}")
    public ResponseEntity<String> eliminarProveedor(@PathVariable Integer id){
        proveedorService.deleteProveedor(id);
        return new ResponseEntity<>("Cliente eliminado", HttpStatus.OK);
    }


}
