package com.example.tiendaMia.persistencia;

import com.example.tiendaMia.dominio.dto.ClienteDto;
import com.example.tiendaMia.dominio.repository.ClienteRepository;
import com.example.tiendaMia.persistencia.crud.CrudClienteEntity;
import com.example.tiendaMia.persistencia.entity.ClienteEntity;
import com.example.tiendaMia.persistencia.mapper.ClienteMapper;
import jakarta.persistence.Entity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClienteEntityRepository implements ClienteRepository {
    private final CrudClienteEntity crudClienteEntity;
    private final ClienteMapper clienteMapper;

    public ClienteEntityRepository(CrudClienteEntity crudClienteEntity, ClienteMapper clienteMapper) {
        this.crudClienteEntity = crudClienteEntity;
        this.clienteMapper = clienteMapper;
    }

    @Override
    public List<ClienteDto> getAll() {
        return clienteMapper.toDto(crudClienteEntity.findAll());
    }

    @Override
    public ClienteDto save(ClienteDto clienteDto) {
        ClienteEntity clienteEntity = clienteMapper.toEntity(clienteDto);

        return clienteMapper.toDto(crudClienteEntity.save(clienteEntity));
    }
}
