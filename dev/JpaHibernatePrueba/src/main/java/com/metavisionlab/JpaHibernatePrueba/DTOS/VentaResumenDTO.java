package com.metavisionlab.JpaHibernatePrueba.DTOS;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VentaResumenDTO {
    private Long codigoVenta;
    private Double total;
    private Integer cantidadProductos;
    private String clienteNombre;
    private String clienteApellido;

    public VentaResumenDTO(Long codigoVenta, Double total, Integer cantidadProductos, String clienteNombre, String clienteApellido) {
        this.codigoVenta = codigoVenta;
        this.total = total;
        this.cantidadProductos = cantidadProductos;
        this.clienteNombre = clienteNombre;
        this.clienteApellido = clienteApellido;
    }

    // Getters
}
