package com.metavisionlab.JpaHibernatePrueba.DTOS;

import com.metavisionlab.JpaHibernatePrueba.model.Cliente;

public class ClienteMapper {

    public static Cliente toEntity(ClienteCreateRequestDTO dto) {
        Cliente c = new Cliente();
        c.setNombre(dto.getNombre());
        c.setApellido(dto.getApellido());
        c.setDni(dto.getDni());
        return c;
    }

    public static void actualizarEntidad(Cliente cliente, ClienteUpdateRequestDTO dto) {
        cliente.setNombre(dto.getNombre());
        cliente.setApellido(dto.getApellido());
        cliente.setDni(dto.getDni());
    }

    public static ClienteResponseDTO toDto(Cliente cliente) {
        String nombreCompleto = cliente.getNombre() + " " + cliente.getApellido();
        return new ClienteResponseDTO(cliente.getId_Cliente(), nombreCompleto);
    }
}
