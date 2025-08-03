package com.metavisionlab.JpaHibernatePrueba.DTOS;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter @Setter
public class VentaResponseDTO {
    private Long codigoVenta;
    private String fechaVenta;
    private Double total;
    private String clienteNombreCompleto;
    private List<ProductoResponseDTO> productos;

    public VentaResponseDTO(Long codigoVenta, String fechaVenta, Double total,
                            String clienteNombreCompleto, List<ProductoResponseDTO> productos) {
        this.codigoVenta = codigoVenta;
        this.fechaVenta = fechaVenta;
        this.total = total;
        this.clienteNombreCompleto = clienteNombreCompleto;
        this.productos = productos;
    }

    // Constructor, getters, setters
}
