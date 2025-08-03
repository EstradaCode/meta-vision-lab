package com.metavisionlab.JpaHibernatePrueba.service;

import com.metavisionlab.JpaHibernatePrueba.model.Producto;
import com.metavisionlab.JpaHibernatePrueba.repository.interfaces.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
public interface IProductoService {
    void crearProducto(Producto producto);
    List<Producto> ListadoProducto();
    Producto obtenerProducto(Long id);
    void eliminarProducto(Long id);
    void editarProducto(Long id, Producto nue);
    List<Producto> obtenerProductosMenosde5();
}
