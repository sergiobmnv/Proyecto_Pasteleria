package com.desarrolloServidor.Pasteleria.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desarrolloServidor.Pasteleria.Entity.IngredienteEntity;

@Repository
public interface  IngredienteRepository extends JpaRepository<IngredienteEntity, Integer>{
    
}
