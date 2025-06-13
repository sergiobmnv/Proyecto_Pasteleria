package com.desarrolloServidor.Pasteleria.Service;

import java.util.List;
import java.util.Map;

import com.desarrolloServidor.Pasteleria.Entity.ClienteEntity;
import com.desarrolloServidor.Pasteleria.Entity.PedidoEntity;
import com.desarrolloServidor.Pasteleria.Entity.ProductoEntity;

public interface  PedidoService {
    PedidoEntity guardarPedido(PedidoEntity pedido);

    List<PedidoEntity> obtenerPedidosPorCliente(Integer clienteId);

    List<PedidoEntity> obtenerTodos();

    void eliminarPedido(Integer id);

    void realizarPedidoDesdeFormulario(Map<String, String[]> parametros, ClienteEntity cliente, List<ProductoEntity> productos);

}
