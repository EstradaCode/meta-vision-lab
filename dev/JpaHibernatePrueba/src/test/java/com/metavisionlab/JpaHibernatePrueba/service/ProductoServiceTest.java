package com.metavisionlab.JpaHibernatePrueba.service;


import com.metavisionlab.JpaHibernatePrueba.DTOS.ProductoCreateRequestDTO;
import com.metavisionlab.JpaHibernatePrueba.DTOS.ProductoResponseDTO;
import com.metavisionlab.JpaHibernatePrueba.repository.interfaces.IProductoRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductoServiceTest {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private IProductoRepository productoRepository;

    @BeforeEach
    void setUp() {
        productoRepository.deleteAll(); // Limpia la base de test
    }

    @Test
    void crearProducto_deberiaRetornarDTOConDatosCorrectos() {
        ProductoCreateRequestDTO dto = new ProductoCreateRequestDTO();
        dto.setNombre("Mate");
        dto.setMarca("Stanley");
        dto.setCosto(4000.0);
        dto.setCantidadDisponible(10.0);

        ProductoResponseDTO result = productoService.crearProducto(dto);

        assertNotNull(result.getId());
        assertEquals("Mate", result.getNombre());
        assertEquals("Stanley", result.getMarca());
    }
}
