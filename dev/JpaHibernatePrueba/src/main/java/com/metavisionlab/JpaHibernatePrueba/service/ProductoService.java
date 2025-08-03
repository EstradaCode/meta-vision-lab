package com.metavisionlab.JpaHibernatePrueba.service;

import com.metavisionlab.JpaHibernatePrueba.DTOS.ProductoCreateRequestDTO;
import com.metavisionlab.JpaHibernatePrueba.DTOS.ProductoMapper;
import com.metavisionlab.JpaHibernatePrueba.DTOS.ProductoResponseDTO;
import com.metavisionlab.JpaHibernatePrueba.DTOS.ProductoUpdateRequestDTO;
import com.metavisionlab.JpaHibernatePrueba.model.Producto;
import com.metavisionlab.JpaHibernatePrueba.repository.interfaces.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoService {

    @Autowired
    private IProductoRepository productoRepository;

    public ProductoResponseDTO crearProducto(ProductoCreateRequestDTO dto) {
        Producto producto = ProductoMapper.toEntity(dto);
        Producto guardado = productoRepository.save(producto);
        return ProductoMapper.toDto(guardado);
    }

    public List<ProductoResponseDTO> listarTodos() {
        return productoRepository.findAll().stream()
                .map(ProductoMapper::toDto)
                .collect(Collectors.toList());
    }

    public ProductoResponseDTO obtenerPorId(Long id) {
        Producto p = productoRepository.findById(id).orElse(null);
        return (p != null) ? ProductoMapper.toDto(p) : null;
    }

    public boolean eliminarProducto(Long id) {
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public ProductoResponseDTO editarProducto(ProductoUpdateRequestDTO dto) {
        Producto producto = productoRepository.findById(dto.getId()).orElse(null);
        if (producto == null) return null;

        ProductoMapper.actualizarEntidad(producto, dto);
        Producto actualizado = productoRepository.save(producto);
        return ProductoMapper.toDto(actualizado);
    }

    public List<ProductoResponseDTO> productosConStockBajo() {
        return productoRepository.findByCantidadDisponibleLessThan(5.0).stream()
                .map(ProductoMapper::toDto)
                .collect(Collectors.toList());
    }
}
