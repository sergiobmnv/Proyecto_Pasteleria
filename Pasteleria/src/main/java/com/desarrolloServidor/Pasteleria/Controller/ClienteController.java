package com.desarrolloServidor.Pasteleria.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    // 1. Mostrar formulario de registro
    @GetMapping("/registro")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("cliente", new ClienteDTO());
        return "Cliente/registroCliente";
    }

    // 2. Registrar cliente
    @PostMapping("/registro")
    public String registrarCliente(@ModelAttribute("cliente") ClienteDTO clienteDTO) {
        clienteService.crear(clienteDTO);
        return "redirect:/clientes/lista";
    }

    // 3. Listar clientes
    @GetMapping("/lista")
    public String listarClientes(Model model) {
        model.addAttribute("clientes", clienteService.obtenerTodos());
        return "Cliente/listaClientes";
    }

    // 4. Mostrar formulario para editar cliente
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") int id, Model model) {
        ClienteDTO cliente = clienteService.obtenerClientePorId(id);
        model.addAttribute("cliente", cliente);
        return "Cliente/editarCliente";
    }

    // 5. Guardar cambios al editar
    @PostMapping("/editar/{id}")
    public String editarCliente(@PathVariable("id") int id, @ModelAttribute("cliente") ClienteDTO clienteDTO) {
        clienteDTO.setId_cliente(id);
        clienteService.actualizar(clienteDTO);
        return "redirect:/clientes/lista";
    }

    
    // 6. Eliminar cliente
    @GetMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable("id") int id) {
        clienteService.eliminarCliente(id);
        return "redirect:/clientes/lista";
    }
}