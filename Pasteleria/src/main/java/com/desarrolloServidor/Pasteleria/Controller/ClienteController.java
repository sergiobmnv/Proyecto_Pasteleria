package com.desarrolloServidor.Pasteleria.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.desarrolloServidor.Pasteleria.Model.ClienteDTO;
import com.desarrolloServidor.Pasteleria.Service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/registro")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("cliente", new ClienteDTO());
        return "Cliente/registroCliente";
    }

    @PostMapping("/registro")
    public String registrarCliente(@ModelAttribute("cliente") ClienteDTO clienteDTO) {
        clienteService.crear(clienteDTO);
        return "redirect:/clientes/registro";
    }
}