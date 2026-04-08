package com.example.tiendaMia.persistencia.crud;

import com.example.tiendaMia.persistencia.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudClienteEntity extends JpaRepository<ClienteEntity,Integer> {

    
}
