package com.metavisionlab.JpaHibernatePrueba.service;

import com.metavisionlab.JpaHibernatePrueba.DTOS.ClienteCreateRequestDTO;
import com.metavisionlab.JpaHibernatePrueba.DTOS.ClienteMapper;
import com.metavisionlab.JpaHibernatePrueba.DTOS.ClienteResponseDTO;
import com.metavisionlab.JpaHibernatePrueba.DTOS.ClienteUpdateRequestDTO;
import com.metavisionlab.JpaHibernatePrueba.model.Cliente;
import com.metavisionlab.JpaHibernatePrueba.repository.interfaces.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private IClienteRepository clienteRepository;

    public ClienteResponseDTO crearCliente(ClienteCreateRequestDTO dto) {
        Cliente cliente = ClienteMapper.toEntity(dto);
        Cliente guardado = clienteRepository.save(cliente);
        return ClienteMapper.toDto(guardado);
    }

    public List<ClienteResponseDTO> listarTodos() {
        return clienteRepository.findAll().stream()
                .map(ClienteMapper::toDto)
                .collect(Collectors.toList());
    }

    public ClienteResponseDTO obtenerPorId(Long id) {
        Cliente c = clienteRepository.findById(id).orElse(null);
        return (c != null) ? ClienteMapper.toDto(c) : null;
    }

    public boolean eliminarCliente(Long id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public ClienteResponseDTO editarCliente(ClienteUpdateRequestDTO dto) {
        Cliente cliente = clienteRepository.findById(dto.getId()).orElse(null);
        if (cliente == null) return null;

        ClienteMapper.actualizarEntidad(cliente, dto);
        Cliente actualizado = clienteRepository.save(cliente);
        return ClienteMapper.toDto(actualizado);
    }
}

