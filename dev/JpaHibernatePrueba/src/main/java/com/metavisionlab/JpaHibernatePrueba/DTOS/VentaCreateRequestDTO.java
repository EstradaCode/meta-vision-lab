package com.metavisionlab.JpaHibernatePrueba.DTOS;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter @Setter
public class VentaCreateRequestDTO {
    private Long clienteId;
    private List<Long> productoIds;

    // Getters y setters
}
