package react.spring.proveedor.v1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import react.spring.proveedor.v1.entity.Proveedor;
import react.spring.proveedor.v1.repository.ProveedorRepository;

import java.util.List;
@Service
public class ProveedorServiceImp implements ProveedorService{

    @Autowired
    ProveedorRepository proveedorRepository;

    @Override
    public List<Proveedor> getAllProveedores() {
        return proveedorRepository.findAll();
    }

    @Override
    public void saveProveedores(Proveedor Proveedor) {
        proveedorRepository.save(Proveedor);
    }

    @Override
    public Proveedor getProveedorById(int id) {
        return proveedorRepository.findById(id).get();
    }

    @Override
    public void deleteProveedor(int id) {
        proveedorRepository.deleteById(id);
    }
}
