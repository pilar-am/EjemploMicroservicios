package react.spring.cliente.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import react.spring.cliente.v1.entity.Cliente;
import react.spring.cliente.v1.service.ClienteService;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT,RequestMethod.DELETE})
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> getAllClientes (){
        try{
            List<Cliente> clientes = clienteService.getAllClientes();
            return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Integer id){
        Cliente cliente = clienteService.getClienteById(id);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @PostMapping("/clientes")
    public ResponseEntity<?> guardarCliente(@RequestBody Cliente cliente){
        try {
            clienteService.saveClientes(cliente);
            return new ResponseEntity<>(cliente, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/clientes/{id}")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable Integer id, @RequestBody Cliente cliente){
        try {
            Cliente cliente1 = clienteService.getClienteById(id);
            cliente1.setNombre(cliente.getNombre());
            cliente1.setEmail(cliente.getEmail());
            cliente1.setDireccion(cliente.getDireccion());
            cliente1.setTelefono(cliente.getTelefono());

            clienteService.saveClientes(cliente1);
            return new ResponseEntity<>(cliente1, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<String> eliminarCliente(@PathVariable Integer id){
        clienteService.deleteCliente(id);
        return new ResponseEntity<>("Cliente eliminado", HttpStatus.OK);
    }

}
