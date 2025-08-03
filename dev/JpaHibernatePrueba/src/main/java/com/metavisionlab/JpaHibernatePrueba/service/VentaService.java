package com.metavisionlab.JpaHibernatePrueba.service;

import com.metavisionlab.JpaHibernatePrueba.DTOS.*;
import com.metavisionlab.JpaHibernatePrueba.model.Cliente;
import com.metavisionlab.JpaHibernatePrueba.model.Producto;
import com.metavisionlab.JpaHibernatePrueba.model.Venta;
import com.metavisionlab.JpaHibernatePrueba.repository.interfaces.IClienteRepository;
import com.metavisionlab.JpaHibernatePrueba.repository.interfaces.IProductoRepository;
import com.metavisionlab.JpaHibernatePrueba.repository.interfaces.IVentaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VentaService {

    @Autowired
    private IVentaRepository ventaRepository;

    @Autowired
    private IProductoRepository productoRepository;

    @Autowired
    private IClienteRepository clienteRepository;

    // ✅ Crear venta
    public VentaResponseDTO crearVenta(VentaCreateRequestDTO dto) {
        Cliente cliente = clienteRepository.findById(dto.getClienteId()).orElse(null);
        if (cliente == null) throw new EntityNotFoundException("Cliente no encontrado");

        List<Producto> productos = productoRepository.findAllById(dto.getProductoIds());
        if (productos.isEmpty()) throw new EntityNotFoundException("Productos no encontrados");

        Venta venta = VentaMapper.toEntity(dto, cliente, productos);
        Venta guardada = ventaRepository.save(venta);
        return VentaMapper.toResponseDTO(guardada);
    }

    // ✅ Listar todas las ventas
    public List<VentaResponseDTO> listarVentas() {
        return ventaRepository.findAll().stream()
                .map(VentaMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    // ✅ Obtener una venta por ID
    public VentaResponseDTO obtenerVenta(Long id) {
        Venta venta = ventaRepository.findById(id).orElse(null);
        return (venta != null) ? VentaMapper.toResponseDTO(venta) : null;
    }

    // ✅ Eliminar una venta
    public boolean eliminarVenta(Long id) {
        if (ventaRepository.existsById(id)) {
            ventaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // ✅ Editar una venta (simplificada: reemplaza cliente y productos)
    public VentaResponseDTO editarVenta(Long id, VentaCreateRequestDTO dto) {
        Venta venta = ventaRepository.findById(id).orElse(null);
        if (venta == null) return null;

        Cliente cliente = clienteRepository.findById(dto.getClienteId()).orElse(null);
        List<Producto> productos = productoRepository.findAllById(dto.getProductoIds());

        if (cliente == null || productos.isEmpty()) return null;

        venta.setCliente(cliente);
        venta.setListaProductos(productos);
        double total = productos.stream().mapToDouble(Producto::getCosto).sum();
        venta.setTotal(total);
        venta.setFecha_venta(LocalDate.now());

        return VentaMapper.toResponseDTO(ventaRepository.save(venta));
    }

    // ✅ Obtener productos de una venta
    public List<ProductoResponseDTO> obtenerProductosDeVenta(Long ventaId) {
        Venta venta = ventaRepository.findById(ventaId).orElse(null);
        if (venta == null) return Collections.emptyList();

        return venta.getListaProductos().stream()
                .map(ProductoMapper::toDto)
                .collect(Collectors.toList());
    }

    // ✅ Obtener la venta con mayor monto total
    public VentaResumenDTO obtenerVentaMayor() {
        Venta venta = ventaRepository.findTopByOrderByTotalDesc();
        return (venta != null) ? VentaMapper.toResumenDTO(venta) : null;
    }
}

