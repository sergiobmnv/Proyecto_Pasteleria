package com.desarrolloServidor.Pasteleria.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
    @GetMapping("/cliente/home")
    public String homeCliente(HttpSession session, Model model) {
        if (session.getAttribute("usuarioLogueado") == null) {
            return "redirect:/login";
        }
        return "Login/clienteHome";
    }

    @GetMapping("/empleado/home")
    public String homeEmpleado(HttpSession session, Model model) {
        if (session.getAttribute("usuarioLogueado") == null) {
            return "redirect:/login";
        }
        return "Login/empleadoHome";
    }
}
