package com.desarrolloServidor.Pasteleria.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.desarrolloServidor.Pasteleria.Entity.ClienteEntity;
import com.desarrolloServidor.Pasteleria.Entity.PedidoEntity;
import com.desarrolloServidor.Pasteleria.Model.ClienteDTO;
import com.desarrolloServidor.Pasteleria.Service.ClienteService;
import com.desarrolloServidor.Pasteleria.Service.PedidoService;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private PedidoService pedidoService;

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
    public String guardarCliente(@ModelAttribute("cliente") ClienteDTO clienteDTO, RedirectAttributes redirectAttrs) {
        try {
            if (clienteDTO.getId_cliente() == null) {
                clienteService.guardarCliente(clienteDTO);
            } else {
                clienteService.actualizarClienteDTO(clienteDTO.getId_cliente(), clienteDTO);
            }
            return "redirect:/clientes/mostrar";
        } catch (IllegalArgumentException e) {
            redirectAttrs.addFlashAttribute("errorRol", e.getMessage());
            redirectAttrs.addFlashAttribute("cliente", clienteDTO);
            return "redirect:/clientes/registro";
        }
    }

    // Eliminar un cliente.
    @GetMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable Integer id) {
        clienteService.eliminarCliente(id);

        return "redirect:/clientes/mostrar";
    }

    @GetMapping("/home")
    public String homeCliente(HttpSession session, Model model) {
    ClienteEntity cliente = (ClienteEntity) session.getAttribute("usuarioLogueado");
    model.addAttribute("cliente", cliente);

    List<PedidoEntity> pedidos = pedidoService.obtenerPedidosPorCliente(cliente.getIdCliente());
    model.addAttribute("pedidosActivos", pedidos);

    return "Login/clienteHome";
}
}