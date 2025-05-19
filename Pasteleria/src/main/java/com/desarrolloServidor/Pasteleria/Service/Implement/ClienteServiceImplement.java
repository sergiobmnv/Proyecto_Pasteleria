package com.desarrolloServidor.Pasteleria.Service.Implement;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    // GUARDAR cliente nuevo
    @Override
    public ClienteDTO guardarCliente(ClienteDTO dto) {
        ClienteEntity cliente = new ClienteEntity();

        cliente.setNombre(dto.getNombre());
        cliente.setApellidos(dto.getApellidos());
        cliente.setDireccion(dto.getDireccion());
        cliente.setContrasenia(dto.getContrasenia());
        cliente.setFechanac(dto.getFechanac());
        cliente.setProducto(dto.getProducto());
        cliente.setEmail(dto.getEmail());
        cliente.setTelefono(dto.getTelefono());
        if (dto.getPrecio_pedido() != null) {
            cliente.setPrecioPedido(BigDecimal.valueOf(dto.getPrecio_pedido()));
        }
        cliente.setObservaciones(dto.getObservacion());

        // Guardamos el cliente en la base de datos
        clienteRepository.save(cliente);

        return dto;
    }

    // OBTENER TODOS los clientes
    @Override
    public List<ClienteDTO> obtenerTodos() {
        List<ClienteEntity> listaClientes = clienteRepository.findAll();
        List<ClienteDTO> listaDTO = new ArrayList<>();

        for (ClienteEntity cliente : listaClientes) {
            ClienteDTO dto = new ClienteDTO();

            dto.setId_cliente(cliente.getIdCliente());
            dto.setNombre(cliente.getNombre());
            dto.setApellidos(cliente.getApellidos());
            dto.setDireccion(cliente.getDireccion());
            dto.setContrasenia(cliente.getContrasenia());
            dto.setFechanac(cliente.getFechaNac());
            dto.setProducto(cliente.getProducto());
            dto.setEmail(cliente.getEmail());
            dto.setTelefono(cliente.getTelefono());

            if (cliente.getPrecioPedido() != null) {
                dto.setPrecio_pedido(cliente.getPrecioPedido().doubleValue());
            }

            dto.setObservacion(cliente.getObservaciones());

            listaDTO.add(dto);
        }
        return listaDTO;
    }

    @Override
    public ClienteDTO actualizarClienteDTO(Integer id, ClienteDTO clienteDTO) {

        Optional<ClienteEntity> clienteOpt = clienteRepository.findById(id);

        if (!clienteOpt.isPresent()) {
            return null; // O lanzar excepción, según prefieras
        }

        ClienteEntity cliente = clienteOpt.get();

        cliente.setNombre(clienteDTO.getNombre());
        cliente.setApellidos(clienteDTO.getApellidos());
        cliente.setDireccion(clienteDTO.getDireccion());
        cliente.setContrasenia(clienteDTO.getContrasenia());
        cliente.setFechanac(clienteDTO.getFechanac());
        cliente.setProducto(clienteDTO.getProducto());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setTelefono(clienteDTO.getTelefono());

        // En caso de que el precio sea Null, no entraria en la funcion BigDecimal para que no de error
        if (clienteDTO.getPrecio_pedido() != null) {
            cliente.setPrecioPedido(BigDecimal.valueOf(clienteDTO.getPrecio_pedido()));
        } else {
            cliente.setPrecioPedido(null);
        }

        cliente.setObservaciones(clienteDTO.getObservacion());

        clienteRepository.save(cliente);

        return clienteDTO;
    }

    // ELIMINAR cliente por id
    @Override
    public void eliminarCliente(Integer id) {
        clienteRepository.deleteById(id);
    }

}
