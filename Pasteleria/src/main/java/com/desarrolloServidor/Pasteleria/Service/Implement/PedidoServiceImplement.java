package com.desarrolloServidor.Pasteleria.Service.Implement;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desarrolloServidor.Pasteleria.Entity.ClienteEntity;
import com.desarrolloServidor.Pasteleria.Entity.IngredienteEntity;
import com.desarrolloServidor.Pasteleria.Entity.IngredienteProductoEntity;
import com.desarrolloServidor.Pasteleria.Entity.PedidoEntity;
import com.desarrolloServidor.Pasteleria.Entity.ProductoEntity;
import com.desarrolloServidor.Pasteleria.Repository.IngredienteRepository;
import com.desarrolloServidor.Pasteleria.Repository.PedidoRepository;
import com.desarrolloServidor.Pasteleria.Service.PedidoService;

@Service
public class PedidoServiceImplement implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private IngredienteRepository ingredienteRepository;

    @Override
    public PedidoEntity guardarPedido(PedidoEntity pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public List<PedidoEntity> obtenerPedidosPorCliente(Integer clienteId) {
        return pedidoRepository.findByCliente_IdCliente(clienteId);
    }

    @Override
    public List<PedidoEntity> obtenerTodos() {
        return pedidoRepository.findAll();
    }

    @Override
    public void eliminarPedido(Integer id) {
        pedidoRepository.deleteById(id);
    }

    @Override
    public void realizarPedidoDesdeFormulario(Map<String, String[]> parametros, ClienteEntity cliente, List<ProductoEntity> productos) {
        for (ProductoEntity producto : productos) {
            String claveCantidad = "cantidad_" + producto.getIdProducto();
            if (parametros.containsKey(claveCantidad)) {
                String[] valores = parametros.get(claveCantidad);
                if (valores != null && valores.length > 0) {
                    try {
                        int cantidadPedida = Integer.parseInt(valores[0]);
                        if (cantidadPedida > 0) {

                            // ✅ Verificar si hay ingredientes suficientes
                            boolean sePuedePreparar = true;
                            for (IngredienteProductoEntity ip : producto.getIngredientesProducto()) {
                                int cantidadNecesariaTotal = ip.getCantidadNecesaria() * cantidadPedida;
                                int stockDisponible = ip.getIngrediente().getStock();

                                if (stockDisponible < cantidadNecesariaTotal) {
                                    sePuedePreparar = false;
                                    break;
                                }
                            }

                            if (sePuedePreparar) {
                                // Crear pedido
                                PedidoEntity pedido = new PedidoEntity();
                                pedido.setCliente(cliente);
                                pedido.setProducto(producto);
                                pedido.setCantidad(cantidadPedida);
                                pedido.setEstado("PENDIENTE");
                                pedidoRepository.save(pedido);

                                // Descontar ingredientes
                                for (IngredienteProductoEntity ip : producto.getIngredientesProducto()) {
                                    int cantidadUsada = ip.getCantidadNecesaria() * cantidadPedida;
                                    IngredienteEntity ingrediente = ip.getIngrediente();
                                    ingrediente.setStock(ingrediente.getStock() - cantidadUsada);
                                    ingredienteRepository.save(ingrediente); // ✅ guardamos el nuevo stock
                                }

                            } else {
                                // Si no hay stock suficiente puedes mostrar un mensaje al usuario (más adelante)
                                System.out.println("No hay ingredientes suficientes para el producto: " + producto.getNombre());
                            }
                        }
                    } catch (NumberFormatException e) {
                        // ignorar valores inválidos
                    }
                }
            }
        }
    }

}
