package com.metavisionlab.JpaHibernatePrueba.repository.interfaces;

import com.metavisionlab.JpaHibernatePrueba.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository extends JpaRepository<Cliente,Long> {
}
