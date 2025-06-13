package com.desarrolloServidor.Pasteleria.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desarrolloServidor.Pasteleria.Entity.PedidoEntity;

public interface  PedidoRepository extends JpaRepository<PedidoEntity, Integer>{

    public List<PedidoEntity> findByCliente_IdCliente(Integer clienteId);
    
}
