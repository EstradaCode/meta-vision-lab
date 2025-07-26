package com.metavisionlab.JpaHibernatePrueba.service;

import com.metavisionlab.JpaHibernatePrueba.model.Cliente;
import com.metavisionlab.JpaHibernatePrueba.repository.interfaces.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.support.NullValue;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClienteService implements IClienteService{
    @Autowired
    private IClienteRepository clienteRepository;
    @Override
    public void crearCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> ListadoClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente ObtenerCliente(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override // modificar y devolver el objeto modificado mejora el uso rest
    public void editarCLiente(Long id, Cliente nue) {
        Cliente cli= ObtenerCliente(id);
        if( cli != null){
            cli.setId_Cliente(nue.getId_Cliente());
            cli.setNombre(nue.getNombre());
            cli.setApellido(nue.getApellido());
            cli.setDni(nue.getDni());
            clienteRepository.save(cli);
        }
    }
}
