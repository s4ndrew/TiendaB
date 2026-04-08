package com.example.tiendaMia.dominio.service;

import com.example.tiendaMia.dominio.dto.ClienteDto;
import com.example.tiendaMia.dominio.repository.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    private  final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ClienteDto save(ClienteDto clienteDto){
        return clienteRepository.save(clienteDto);
    }
}
