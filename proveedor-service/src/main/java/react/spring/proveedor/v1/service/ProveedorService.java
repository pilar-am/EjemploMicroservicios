package react.spring.proveedor.v1.service;

import react.spring.proveedor.v1.entity.Proveedor;

import java.util.List;

public interface ProveedorService {

    List<Proveedor> getAllProveedores();

    void saveProveedores(Proveedor proveedor);

    Proveedor getProveedorById(int id);

    void deleteProveedor(int id);
}
