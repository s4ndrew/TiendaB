package com.example.tiendaMia.dominio.service;

import com.example.tiendaMia.dominio.dto.ClienteDto;
import com.example.tiendaMia.dominio.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    private  final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ClienteDto save(ClienteDto clienteDto){
        return clienteRepository.save(clienteDto);
    }

    public List<ClienteDto> getAll(){
        return clienteRepository.getAll();
    }

    public void delete(Integer id){
            clienteRepository.delete(id);
    }
}
