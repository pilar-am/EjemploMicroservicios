package react.spring.cliente.v1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import react.spring.cliente.v1.entity.Cliente;
import react.spring.cliente.v1.repository.ClienteRepository;

import java.util.List;

@Service
public class ClienteServiceImp implements ClienteService{

    @Autowired
    ClienteRepository clienteRepository;
    @Override
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public void saveClientes(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public Cliente getClienteById(int id) {
        return clienteRepository.findById(id).get();
    }

    @Override
    public void deleteCliente(int id) {
        clienteRepository.deleteById(id);
    }
}
