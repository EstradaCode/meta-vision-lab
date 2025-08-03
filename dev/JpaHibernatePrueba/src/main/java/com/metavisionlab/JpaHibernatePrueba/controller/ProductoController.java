package com.metavisionlab.JpaHibernatePrueba.controller;

import com.metavisionlab.JpaHibernatePrueba.DTOS.ProductoCreateRequestDTO;
import com.metavisionlab.JpaHibernatePrueba.DTOS.ProductoResponseDTO;
import com.metavisionlab.JpaHibernatePrueba.DTOS.ProductoUpdateRequestDTO;
import com.metavisionlab.JpaHibernatePrueba.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping("/crear")
    public ResponseEntity<ProductoResponseDTO> crear(@RequestBody ProductoCreateRequestDTO dto) {
        ProductoResponseDTO creado = productoService.crearProducto(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }


    @GetMapping
    public ResponseEntity<List<ProductoResponseDTO>> listar() {
        return ResponseEntity.ok(productoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoResponseDTO> obtener(@PathVariable Long id) {
        ProductoResponseDTO dto = productoService.obtenerPorId(id);
        return (dto != null) ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PutMapping("/editar")
    public ResponseEntity<ProductoResponseDTO> editar(@RequestBody ProductoUpdateRequestDTO dto) {
        ProductoResponseDTO actualizado = productoService.editarProducto(dto);
        return (actualizado != null) ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        return productoService.eliminarProducto(id) ?
                ResponseEntity.noContent().build() :
                ResponseEntity.notFound().build();
    }

    @GetMapping("/falta_stock")
    public ResponseEntity<List<ProductoResponseDTO>> faltaStock() {
        return ResponseEntity.ok(productoService.productosConStockBajo());
    }
}
