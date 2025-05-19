package com.desarrolloServidor.Pasteleria.Service;

import java.util.List;

import com.desarrolloServidor.Pasteleria.Model.ClienteDTO;


public interface ClienteService {

    ClienteDTO guardarCliente (ClienteDTO clienteDTO);
    
    List <ClienteDTO> obtenerTodos();

    ClienteDTO actualizarClienteDTO (Integer id, ClienteDTO clienteDTO);

    void eliminarCliente (Integer id);

}
