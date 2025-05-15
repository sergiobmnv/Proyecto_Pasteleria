package com.desarrolloServidor.Pasteleria.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desarrolloServidor.Pasteleria.Entity.Empleado;

public interface  EmpleadoRepository extends JpaRepository <Empleado, Long>{
    
    Optional<Empleado> findByUsername(String username);
    
}
