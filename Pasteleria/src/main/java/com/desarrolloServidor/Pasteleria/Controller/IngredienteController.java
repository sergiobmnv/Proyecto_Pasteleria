package com.desarrolloServidor.Pasteleria.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.desarrolloServidor.Pasteleria.Model.IngredienteDTO;
import com.desarrolloServidor.Pasteleria.Service.IngredienteService;

@Controller
@RequestMapping("/ingredientes")
public class IngredienteController {

    @Autowired
    private IngredienteService ingredienteService;

    // Mostrar lista de ingredientes
    @GetMapping
    public String mostrarIngredientes(Model model) {
        List<IngredienteDTO> ingredientes = ingredienteService.listarIngredientes();
        model.addAttribute("ingredientes", ingredientes);
        return "Ingrediente/listaIngredientes";
    }

    // Mostrar formulario para nuevo ingrediente
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevoIngrediente(Model model) {
        model.addAttribute("ingrediente", new IngredienteDTO());
        return "Ingrediente/nuevoIngrediente";
    }

    // Guardar ingrediente desde formulario
    @PostMapping
    public String guardarIngrediente(@ModelAttribute("ingrediente") IngredienteDTO ingredienteDTO) {
        ingredienteService.registrarIngrediente(ingredienteDTO);
        return "redirect:/ingredientes";
    }

    // Mostrar formulario para editar ingrediente
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarIngrediente(@PathVariable Integer id, Model model) {
        IngredienteDTO ingrediente = ingredienteService.obtenerIngredientePorId(id);
        if (ingrediente != null) {
            model.addAttribute("ingrediente", ingrediente);
            return "Ingrediente/editarIngrediente";
        } else {
            return "redirect:/ingredientes";
        }
    }

    // Actualizar ingrediente desde formulario
    @PostMapping("/actualizar/{id}")
    public String actualizarIngrediente(@PathVariable Integer id, @ModelAttribute("ingrediente") IngredienteDTO ingredienteDTO) {
        ingredienteService.actualizarIngrediente(id, ingredienteDTO);
        return "redirect:/ingredientes";
    }

    // Eliminar ingrediente
    @GetMapping("/eliminar/{id}")
    public String eliminarIngrediente(@PathVariable Integer id) {
        ingredienteService.eliminarIngrediente(id);
        return "redirect:/ingredientes";
    }
}
