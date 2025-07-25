package com.metavisionlab.JpaHibernatePrueba.repository.interfaces;

import com.metavisionlab.JpaHibernatePrueba.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVentaRepository extends JpaRepository<Venta,Long> {
}
