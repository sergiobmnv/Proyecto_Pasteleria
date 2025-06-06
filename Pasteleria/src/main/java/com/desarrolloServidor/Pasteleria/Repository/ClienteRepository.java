package com.desarrolloServidor.Pasteleria.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desarrolloServidor.Pasteleria.Entity.ClienteEntity;


@Repository
public interface  ClienteRepository extends JpaRepository <ClienteEntity, Integer>{

    ClienteEntity findByEmailAndContrasenia(String email, String contrasenia);

}
