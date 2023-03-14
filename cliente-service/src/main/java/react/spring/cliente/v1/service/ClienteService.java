package react.spring.cliente.v1.service;

import react.spring.cliente.v1.entity.Cliente;

import java.util.List;

public interface ClienteService {

    List<Cliente> getAllClientes();

    void saveClientes(Cliente cliente);

    Cliente getClienteById(int id);

    void deleteCliente(int id);
}
