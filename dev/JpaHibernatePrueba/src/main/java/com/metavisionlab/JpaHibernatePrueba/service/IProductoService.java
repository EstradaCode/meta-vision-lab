package com.metavisionlab.JpaHibernatePrueba.service;

import com.metavisionlab.JpaHibernatePrueba.model.Producto;

import java.util.List;

public interface IProductoService {
    void crearProducto(Producto producto);
    List<Producto> ListadoProducto();
    void eliminarProducto(Long id);
    void editarProducto(Long id);
}
