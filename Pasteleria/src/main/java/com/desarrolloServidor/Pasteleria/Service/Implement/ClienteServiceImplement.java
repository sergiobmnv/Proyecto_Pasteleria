package com.desarrolloServidor.Pasteleria.Service.Implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desarrolloServidor.Pasteleria.Entity.ClienteEntity;
import com.desarrolloServidor.Pasteleria.Model.ClienteDTO;
import com.desarrolloServidor.Pasteleria.Repository.ClienteRepository;
import com.desarrolloServidor.Pasteleria.Service.ClienteService;

@Service
public class ClienteServiceImplement implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public void crear (ClienteDTO cliente) {
        ClienteEntity entity = new ClienteEntity();
        entity.setNombre(cliente.getNombre());
        entity.setApellidos(cliente.getApellidos());
        entity.setDireccion(cliente.getDireccion());
        entity.setContrasenia(cliente.getContrasenia());
        entity.setFechanac(cliente.getFechanac());
        entity.setEmail(cliente.getEmail());
        entity.setTelefono(cliente.getTelefono());
        
        clienteRepository.save(entity);
    }


    @Override
    public void guardarCliente(ClienteDTO dto) {
        ClienteEntity cliente = new ClienteEntity();

        // Copiamos directamente los campos
        cliente.setIdCliente(dto.getId_cliente());
        cliente.setNombre(dto.getNombre());
        cliente.setApellidos(dto.getApellidos());
        cliente.setDireccion(dto.getDireccion());
        cliente.setEmail(dto.getEmail());
        cliente.setTelefono(dto.getTelefono());
        cliente.setContrasenia(dto.getContrasenia());
        cliente.setFechanac(dto.getFechanac());

        // Si tu formulario no incluye esto, puedes establecer valores por defecto:
        cliente.setProducto("Ninguno");
        cliente.setEstado("Activo");
        cliente.setObservaciones("");
        cliente.setPrecioPedido(null);

        clienteRepository.save(cliente);
    }

    @Override
    public List<ClienteDTO> listarClientes() {
        return clienteRepository.findAll().stream().map(cliente -> {
            ClienteDTO dto = new ClienteDTO();
            dto.setId_cliente(dto.getId_cliente());
            dto.setNombre(cliente.getNombre());
            dto.setApellidos(cliente.getApellidos());
            dto.setDireccion(cliente.getDireccion());
            dto.setEmail(cliente.getEmail());
            dto.setTelefono(cliente.getTelefono());
            dto.setContrasenia(cliente.getContrasenia());
            dto.setFechanac(cliente.getFechaNac());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public ClienteDTO obtenerClientePorId(Integer id) {
        Optional<ClienteEntity> cliente = clienteRepository.findById(id);
        if (cliente.isPresent()) {
            ClienteEntity c = cliente.get();
            ClienteDTO dto = new ClienteDTO();
            dto.setId_cliente(c.getIdCliente());
            dto.setNombre(c.getNombre());
            dto.setApellidos(c.getApellidos());
            dto.setDireccion(c.getDireccion());
            dto.setEmail(c.getEmail());
            dto.setTelefono(c.getTelefono());
            dto.setContrasenia(c.getContrasenia());
            dto.setFechanac(c.getFechaNac());
            return dto;
        }
        return null;
    }

    @Override
    public void eliminarCliente(Integer id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public void actualizar (ClienteDTO cliente) {

    }

    @Override
public List<ClienteDTO> obtenerTodos() {
    List<ClienteEntity> entidades = clienteRepository.findAll();
    List<ClienteDTO> dtos = new ArrayList<>();

    for (ClienteEntity entidad : entidades) {
        ClienteDTO dto = new ClienteDTO();
        dto.setId_cliente(entidad.getIdCliente());
        dto.setNombre(entidad.getNombre());
        dto.setApellidos(entidad.getApellidos());
        dto.setEmail(entidad.getEmail());
        dto.setTelefono(entidad.getTelefono());
        dto.setFechanac(entidad.getFechaNac());

        dtos.add(dto);
    }

    return dtos;
}

}