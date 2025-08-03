package com.metavisionlab.JpaHibernatePrueba.DTOS;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductoUpdateRequestDTO {
    private Long id;
    private String nombre;
    private String marca;
    private Double costo;
    private Double cantidadDisponible;
}
