package com.metavisionlab.JpaHibernatePrueba.service;

import com.metavisionlab.JpaHibernatePrueba.model.Cliente;

import java.util.List;

public interface IClienteService { //NOTA: AL UTILIZAR DTOS, ESTAS INTERFACES Y MI LOGICA DE NEGOCIO ACABAN DEPENDIENDO TAMBIEN DE ELLOS.
    void crearCliente(Cliente cliente);
    List<Cliente> ListadoClientes();
    Cliente ObtenerCliente(Long id);
    void eliminarCliente(Long id);
    void editarCLiente(Long id, Cliente nue); // deberia ver como modificar este campo
}
