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
        return "Login/login";  // Asegúrate de que la ruta sea correcta
    }

    @PostMapping("/login")
    public String procesarLogin(@ModelAttribute("login") LoginDTO loginDTO, Model model, HttpSession session) {
        // Buscar al cliente por email y contraseña
        ClienteEntity cliente = clienteRepository.findByEmailAndContrasenia(
                loginDTO.getEmail(), loginDTO.getContrasenia()
        );

        // Verificar si el cliente existe
        if (cliente != null) {
            session.setAttribute("usuarioLogueado", cliente);

            // Redirigir según el rol (empleado o cliente)
            if (cliente.isEsEmpleado()) {
                return "redirect:/empleado/home";  // Ruta para empleados
            } else {
                return "redirect:/cliente/home";  // Ruta para clientes
            }
        } else {
            // Si las credenciales son incorrectas, mostramos el error en la vista
            model.addAttribute("error", "Email o contraseña incorrectos");
            return "Login/login";  // Asegúrate de que la vista sea correcta
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // Invalida la sesión para cerrar la sesión del usuario
        session.invalidate();
        return "redirect:/login";  // Redirige de vuelta a la página de login
    }

}
