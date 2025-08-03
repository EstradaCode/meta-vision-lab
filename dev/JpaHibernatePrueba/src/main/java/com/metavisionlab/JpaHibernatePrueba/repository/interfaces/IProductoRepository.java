package com.metavisionlab.JpaHibernatePrueba.repository.interfaces;

import com.metavisionlab.JpaHibernatePrueba.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductoRepository extends JpaRepository<Producto,Long> {
    List<Producto> findByCantidadDisponibleLessThan(Double cantidad);
    //void UpdateStock();
}
