package com.metavisionlab.JpaHibernatePrueba.DTOS;

import com.metavisionlab.JpaHibernatePrueba.model.Cliente;
import com.metavisionlab.JpaHibernatePrueba.model.Producto;
import com.metavisionlab.JpaHibernatePrueba.model.Venta;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class VentaMapper {

    // Para crear una Venta desde el DTO de creación
    public static Venta toEntity(
            VentaCreateRequestDTO dto,
            Cliente cliente,
            List<Producto> productos
    ) {
        Venta venta = new Venta();
        venta.setFecha_venta(LocalDate.now());
        venta.setCliente(cliente);
        venta.setListaProductos(productos);
        // Calculamos el total sumando los costos
        double total = productos.stream()
                .mapToDouble(Producto::getCosto)
                .sum();
        venta.setTotal(total);
        return venta;
    }

    // Para mostrar una venta detallada
    public static VentaResponseDTO toResponseDTO(Venta venta) {
        String clienteNombreCompleto = venta.getCliente().getNombre() + " " + venta.getCliente().getApellido();

        List<ProductoResponseDTO> productosDTO = venta.getListaProductos().stream()
                .map(ProductoMapper::toDto)
                .collect(Collectors.toList());

        return new VentaResponseDTO(
                venta.getId_venta(),
                venta.getFecha_venta().toString(),
                venta.getTotal(),
                clienteNombreCompleto,
                productosDTO
        );
    }

    // Para devolver solo un resumen (ej: mayor_venta)
    public static VentaResumenDTO toResumenDTO(Venta venta) {
        return new VentaResumenDTO(
                venta.getId_venta(),
                venta.getTotal(),
                venta.getListaProductos().size(),
                venta.getCliente().getNombre(),
                venta.getCliente().getApellido()
        );
    }
}
