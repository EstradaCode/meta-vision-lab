package com.metavisionlab.JpaHibernatePrueba.service;

import com.metavisionlab.JpaHibernatePrueba.model.Venta;

import java.util.List;

public interface IVentasService {
    void crearVenta(Venta venta);
    List<Venta> ListadoCompras();
    Venta obtenerVenta(Long id);
    void eliminarVenta(Long id_venta); // debe ir relacionado a un cliente particular
    void editarVenta(Long id_venta, Venta nue);
}
