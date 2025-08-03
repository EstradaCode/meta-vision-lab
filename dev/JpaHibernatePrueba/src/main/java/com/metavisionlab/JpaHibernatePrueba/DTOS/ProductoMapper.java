package com.metavisionlab.JpaHibernatePrueba.DTOS;

import com.metavisionlab.JpaHibernatePrueba.model.Producto;

public class ProductoMapper {

    public static Producto toEntity(ProductoCreateRequestDTO dto) {
        Producto p = new Producto();
        p.setNombre(dto.getNombre());
        p.setMarca(dto.getMarca());
        p.setCosto(dto.getCosto());
        p.setCantidad_disponible(dto.getCantidadDisponible());
        return p;
    }

    public static void actualizarEntidad(Producto producto, ProductoUpdateRequestDTO dto) {
        producto.setNombre(dto.getNombre());
        producto.setMarca(dto.getMarca());
        producto.setCosto(dto.getCosto());
        producto.setCantidad_disponible(dto.getCantidadDisponible());
    }

    public static ProductoResponseDTO toDto(Producto p) {
        return new ProductoResponseDTO(
                p.getId_producto(),
                p.getNombre(),
                p.getMarca(),
                p.getCosto(),
                p.getCantidad_disponible()
        );
    }
}
