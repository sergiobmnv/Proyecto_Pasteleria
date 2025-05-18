package com.desarrolloServidor.Pasteleria.Service;

import java.util.List;

import com.desarrolloServidor.Pasteleria.Model.ClienteDTO;

public interface ClienteService {

    void crear(ClienteDTO clienteDTO);
    void guardarCliente(ClienteDTO cliente);
    List<ClienteDTO> listarClientes();
    ClienteDTO obtenerClientePorId(Integer id);
    void eliminarCliente(Integer id);
    Object obtenerTodos();
    void actualizar(ClienteDTO clienteDTO);
    

}
