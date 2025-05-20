package com.desarrolloServidor.Pasteleria.Service;

import java.util.List;

import com.desarrolloServidor.Pasteleria.Model.ProductoDTO;

public interface ProductoService {
    
    List<ProductoDTO> obtenerTodos();
    ProductoDTO obtenerPorId(int id);
    ProductoDTO guardarProducto(ProductoDTO productoDTO);
    ProductoDTO actualizarProducto(ProductoDTO productoDTO);
    void eliminarProducto(int id);
    
}
