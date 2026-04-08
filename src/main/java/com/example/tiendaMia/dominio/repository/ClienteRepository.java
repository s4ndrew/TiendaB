package com.example.tiendaMia.dominio.repository;

import com.example.tiendaMia.dominio.dto.ClienteDto;

import java.util.List;

public interface ClienteRepository {
    List<ClienteDto> getAll();
    ClienteDto save(ClienteDto clienteDto);
}
