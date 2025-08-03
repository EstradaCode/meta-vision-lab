package com.metavisionlab.JpaHibernatePrueba.controller;

import com.metavisionlab.JpaHibernatePrueba.DTOS.ClienteCreateRequestDTO;
import com.metavisionlab.JpaHibernatePrueba.DTOS.ClienteResponseDTO;
import com.metavisionlab.JpaHibernatePrueba.DTOS.ClienteUpdateRequestDTO;
import com.metavisionlab.JpaHibernatePrueba.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/crear")
    public ResponseEntity<ClienteResponseDTO> crear(@RequestBody ClienteCreateRequestDTO dto) {
        return ResponseEntity.ok(clienteService.crearCliente(dto));
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> listar() {
        return ResponseEntity.ok(clienteService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> obtener(@PathVariable Long id) {
        ClienteResponseDTO dto = clienteService.obtenerPorId(id);
        return (dto != null) ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PutMapping("/editar")
    public ResponseEntity<ClienteResponseDTO> editar(@RequestBody ClienteUpdateRequestDTO dto) {
        ClienteResponseDTO actualizado = clienteService.editarCliente(dto);
        return (actualizado != null) ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        return clienteService.eliminarCliente(id) ?
                ResponseEntity.noContent().build() :
                ResponseEntity.notFound().build();
    }
}
