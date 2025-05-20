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

import com.desarrolloServidor.Pasteleria.Model.ProductoDTO;
import com.desarrolloServidor.Pasteleria.Service.ProductoService;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;
    
    // Mostrar todos los productos
    @GetMapping
    public String listarProductos(Model model) {
        List<ProductoDTO> productos = productoService.obtenerTodos();
        model.addAttribute("productos", productos);
        return "Productos/productos"; // Vista: productos.html
    }

    // Mostrar formulario para crear nuevo producto
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevoProducto(Model model) {
        model.addAttribute("producto", new ProductoDTO());
        return "Productos/formularioProductos";
    }

    // Guardar o actualizar producto
    @PostMapping("/guardar")
    public String guardarProducto(@ModelAttribute("producto") ProductoDTO productoDTO) {
        if (productoDTO.getId_producto() > 0) {
            productoService.actualizarProducto(productoDTO);
        } else {
            productoService.guardarProducto(productoDTO);
        }
        return "redirect:/productos";
    }

    // Mostrar formulario para editar producto existente
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarProducto(@PathVariable("id") int id, Model model) {
        ProductoDTO producto = productoService.obtenerPorId(id);
        if (producto != null) {
            model.addAttribute("producto", producto);
            return "Productos/formularioProductos";
        } else {
            return "redirect:/productos";
        }
    }

    // Eliminar producto
    @GetMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable("id") int id) {
        productoService.eliminarProducto(id);
        return "redirect:/productos";
    }
}
