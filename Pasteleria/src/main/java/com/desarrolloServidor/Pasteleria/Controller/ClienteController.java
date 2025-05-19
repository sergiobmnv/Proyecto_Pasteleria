package com.desarrolloServidor.Pasteleria.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.desarrolloServidor.Pasteleria.Model.ClienteDTO;
import com.desarrolloServidor.Pasteleria.Service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Mostrar lista de clientes.
    @GetMapping("/mostrar")
    public String mostrarClientes(Model model) {
        List<ClienteDTO> clientes = clienteService.obtenerTodos();

        // Verificamos que la lista no esté vacía antes de acceder a cualquier índice
        if (clientes == null || clientes.isEmpty()) {
            model.addAttribute("clientes", new ArrayList<>()); // Evita errores en la vista
        } else {
            model.addAttribute("clientes", clientes);
        }
        return "Cliente/listaClientes";
    }

    // Formulario para crear un nuevo Cliente.
    @GetMapping("/registro")
    public String nuevoCliente(Model model) {
        model.addAttribute("cliente", new ClienteDTO());
        return "Cliente/registroCliente";
    }

    // Guardar nuevo cliente o editar al cliente.
    @PostMapping("/guardar")
    public String guardarCliente(ClienteDTO clienteDTO) {

        // Si el cliente no tiene ID es porque es nuevo.
        if (clienteDTO.getId_cliente() == null) {
            clienteService.guardarCliente(clienteDTO);
        } else {
            clienteService.actualizarClienteDTO(clienteDTO.getId_cliente(), clienteDTO);
        }
        return "redirect:/clientes/mostrar";
    }

    // Eliminar un cliente.
    @GetMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable Integer id) {
        clienteService.eliminarCliente(id);

        return "redirect:/clientes/mostrar";
    }
}
