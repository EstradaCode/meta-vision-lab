package com.metavisionlab.JpaHibernatePrueba.DTOS;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductoCreateRequestDTO {
    private String nombre;
    private String marca;
    private Double costo;
    private Double cantidadDisponible;
}
