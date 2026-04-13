package com.example.tiendaMia.dominio.repository;

import com.example.tiendaMia.dominio.dto.ClienteDto;
import com.example.tiendaMia.dominio.dto.updateDto.UpdateClienteDto;

import java.util.List;

public interface ClienteRepository {
    List<ClienteDto> getAll();
    ClienteDto save(ClienteDto clienteDto);
    void delete(Integer id);
    ClienteDto update(Integer id, UpdateClienteDto updateClienteDto);

}
