package com.metavisionlab.JpaHibernatePrueba.controller;

import com.metavisionlab.JpaHibernatePrueba.DTOS.ProductoResponseDTO;
import com.metavisionlab.JpaHibernatePrueba.DTOS.VentaCreateRequestDTO;
import com.metavisionlab.JpaHibernatePrueba.DTOS.VentaResponseDTO;
import com.metavisionlab.JpaHibernatePrueba.DTOS.VentaResumenDTO;
import com.metavisionlab.JpaHibernatePrueba.service.VentaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    // 🔹 Crear venta
    @PostMapping("/crear")
    public ResponseEntity<VentaResponseDTO> crearVenta(@RequestBody VentaCreateRequestDTO dto) {
        try {
            VentaResponseDTO nueva = ventaService.crearVenta(dto);
            return ResponseEntity.ok(nueva);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // 🔹 Listar todas las ventas
    @GetMapping
    public ResponseEntity<List<VentaResponseDTO>> listarVentas() {
        return ResponseEntity.ok(ventaService.listarVentas());
    }

    // 🔹 Obtener una venta específica
    @GetMapping("/{id}")
    public ResponseEntity<VentaResponseDTO> obtenerVenta(@PathVariable Long id) {
        VentaResponseDTO dto = ventaService.obtenerVenta(id);
        return (dto != null) ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    // 🔹 Editar venta (reemplaza cliente y productos)
    @PutMapping("/editar/{id}")
    public ResponseEntity<VentaResponseDTO> editarVenta(@PathVariable Long id, @RequestBody VentaCreateRequestDTO dto) {
        VentaResponseDTO actualizada = ventaService.editarVenta(id, dto);
        return (actualizada != null) ? ResponseEntity.ok(actualizada) : ResponseEntity.notFound().build();
    }

    // 🔹 Eliminar venta
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarVenta(@PathVariable Long id) {
        return ventaService.eliminarVenta(id) ?
                ResponseEntity.noContent().build() :
                ResponseEntity.notFound().build();
    }

    // 🔹 Productos de una venta
    @GetMapping("/productos/{id}")
    public ResponseEntity<List<ProductoResponseDTO>> obtenerProductosDeVenta(@PathVariable Long id) {
        List<ProductoResponseDTO> productos = ventaService.obtenerProductosDeVenta(id);
        return productos.isEmpty() ?
                ResponseEntity.notFound().build() :
                ResponseEntity.ok(productos);
    }

    // 🔹 Venta con mayor total
    @GetMapping("/mayor_venta")
    public ResponseEntity<VentaResumenDTO> obtenerMayorVenta() {
        VentaResumenDTO dto = ventaService.obtenerVentaMayor();
        return (dto != null) ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }
}
