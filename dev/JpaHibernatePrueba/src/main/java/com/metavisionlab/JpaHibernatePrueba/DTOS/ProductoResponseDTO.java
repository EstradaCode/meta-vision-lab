package com.metavisionlab.JpaHibernatePrueba.DTOS;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductoResponseDTO {
    private Long id;
    private String nombre;
    private String marca;
    private Double costo;
    private Double cantidadDisponible;

    // Constructor completo
    public ProductoResponseDTO(Long id, String nombre, String marca, Double costo, Double cantidadDisponible) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.costo = costo;
        this.cantidadDisponible = cantidadDisponible;
    }
}
