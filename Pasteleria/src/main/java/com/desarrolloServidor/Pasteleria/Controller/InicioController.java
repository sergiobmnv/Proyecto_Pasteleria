package com.desarrolloServidor.Pasteleria.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {
    

    @GetMapping("/")
    public String mostrarInicio() {
        return "inicio";
    }

    @GetMapping("/login")
    public String mostrarLogin() {
        return "login";
    }
}
