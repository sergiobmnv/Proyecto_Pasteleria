package com.desarrolloServidor.Pasteleria.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.desarrolloServidor.Pasteleria.Entity.ClienteEntity;
import com.desarrolloServidor.Pasteleria.Model.LoginDTO;
import com.desarrolloServidor.Pasteleria.Repository.ClienteRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/login")
    public String mostrarLogin(Model model) {
        model.addAttribute("login", new LoginDTO());
        return "Login/login";
    }

    @PostMapping("/login")
    public String procesarLogin(@ModelAttribute("login") LoginDTO loginDTO, Model model, HttpSession session) {
        ClienteEntity cliente = clienteRepository.findByEmailAndContrasenia(
                loginDTO.getEmail(), loginDTO.getContrasenia()
        );

        if (cliente != null) {
            session.setAttribute("usuarioLogueado", cliente);
            // Redirige según el rol
            if (Boolean.TRUE.equals(cliente.isEsEmpleado())) {
                return "redirect:/empleado/home";
            } else {
                return "redirect:/cliente/home";
            }
        } else {
            model.addAttribute("error", "Email o contraseña incorrectos");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

}
