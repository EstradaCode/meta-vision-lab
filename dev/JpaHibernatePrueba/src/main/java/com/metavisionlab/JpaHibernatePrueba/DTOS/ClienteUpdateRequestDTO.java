package com.metavisionlab.JpaHibernatePrueba.DTOS;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ClienteUpdateRequestDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;

    // Getters y setters
}
