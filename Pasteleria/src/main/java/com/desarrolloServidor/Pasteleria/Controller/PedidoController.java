package com.desarrolloServidor.Pasteleria.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.desarrolloServidor.Pasteleria.Entity.ClienteEntity;
import com.desarrolloServidor.Pasteleria.Entity.PedidoEntity;
import com.desarrolloServidor.Pasteleria.Entity.ProductoEntity;
import com.desarrolloServidor.Pasteleria.Repository.PedidoRepository;
import com.desarrolloServidor.Pasteleria.Repository.ProductoRepository;
import com.desarrolloServidor.Pasteleria.Service.PedidoService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/realizarPedido")
    public String mostrarFormularioPedido(HttpSession session, Model model) {
        ClienteEntity cliente = (ClienteEntity) session.getAttribute("usuarioLogueado");

        if (cliente == null) {
            return "redirect:/login";
        }

        List<ProductoEntity> pasteles = productoRepository.findAll();

        model.addAttribute("cliente", cliente);
        model.addAttribute("pasteles", pasteles);

        return "Productos/seleccionarProductos";
    }

    @PostMapping("/guardar")
    public String guardarPedido(HttpSession session,
            @RequestParam("productoId") Integer productoId,
            @RequestParam("cantidad") int cantidad) {
        ClienteEntity cliente = (ClienteEntity) session.getAttribute("usuarioLogueado");

        if (cliente == null) {
            return "redirect:/login";
        }

        if (productoId == null || cantidad <= 0) {
            return "redirect:/pedidos/realizarPedido?error=datosInvalidos";
        }

        ProductoEntity producto = productoRepository.findById(productoId).orElse(null);
        if (producto == null) {
            return "redirect:/pedidos/realizarPedido?error=productoNoExiste";
        }

        PedidoEntity nuevoPedido = new PedidoEntity();
        nuevoPedido.setCliente(cliente);
        nuevoPedido.setProducto(producto);
        nuevoPedido.setCantidad(cantidad);
        nuevoPedido.setEstado("Pendiente");

        pedidoRepository.save(nuevoPedido);

        return "redirect:/clientes/home";
    }

    @GetMapping("/home")
    public String homeCliente(HttpSession session, Model model) {
        ClienteEntity cliente = (ClienteEntity) session.getAttribute("usuarioLogueado");

        if (cliente == null) {
            return "redirect:/login";
        }

        List<PedidoEntity> pedidos = pedidoService.obtenerPedidosPorCliente(cliente.getIdCliente());

        model.addAttribute("cliente", cliente);
        model.addAttribute("pedidos", pedidos);

        return "Clientes/home";
    }

    @PostMapping("/cancelarPedido/{id}")
    public String cancelarPedido(@PathVariable("id") Integer id, HttpSession session) {
        PedidoEntity pedido = pedidoRepository.findById(id).orElse(null);

        if (pedido != null && "Pendiente".equalsIgnoreCase(pedido.getEstado())) {
            pedido.setEstado("Cancelado");
            pedidoRepository.save(pedido);
        }

        return "redirect:/clientes/home";
    }

}
