package com.metavisionlab.JpaHibernatePrueba.DTOS;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ClienteResponseDTO {
    private Long id;
    private String nombreCompleto;

    public ClienteResponseDTO(Long id, String nombreCompleto) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
    }

    // Getters
}