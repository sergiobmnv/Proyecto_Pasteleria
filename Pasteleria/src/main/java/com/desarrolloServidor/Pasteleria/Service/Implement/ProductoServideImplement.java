package com.desarrolloServidor.Pasteleria.Service.Implement;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desarrolloServidor.Pasteleria.Entity.ProductoEntity;
import com.desarrolloServidor.Pasteleria.Model.ProductoDTO;
import com.desarrolloServidor.Pasteleria.Repository.ProductoRepository;
import com.desarrolloServidor.Pasteleria.Service.ProductoService;



@Service
public class ProductoServideImplement implements ProductoService{
    
    @Autowired
    private ProductoRepository produtoRepository;

    private ProductoDTO convertiProductoDTO (ProductoEntity entity) {
        ProductoDTO dto = new ProductoDTO();

        dto.setId_producto(entity.getIdProducto());
        dto.setNombre(entity.getNombre());
        dto.setDescripcion(entity.getDescripcion());
        dto.setPrecio(entity.getPrecio().doubleValue());
        dto.setStock(entity.getStock());
        dto.setCategoria(entity.getCategoria());
        return dto;
        
    }

    private ProductoEntity convertirAProductoEntity (ProductoDTO dto) {
        ProductoEntity entity = new ProductoEntity();

        if (dto.getId_producto() > 0) {
            entity.setIdProducto(dto.getId_producto());
        }

        entity.setNombre(dto.getNombre());
        entity.setDescripcion(dto.getDescripcion());
        entity.setPrecio(BigDecimal.valueOf(dto.getPrecio()));
        entity.setStock(dto.getStock());
        entity.setCategoria(dto.getCategoria());

        return entity;
    }

    @Override
    public List<ProductoDTO> obtenerTodos() {
        List<ProductoEntity> entidades = produtoRepository.findAll();
        List<ProductoDTO> dtos = new ArrayList<>();

        for (ProductoEntity entity : entidades) {
            dtos.add(convertiProductoDTO(entity));
        }

        return dtos;
    }

    @Override
    public ProductoDTO obtenerPorId(int id) {
        ProductoEntity entity = produtoRepository.findById(id).orElse(null);
        if (entity != null) {
            return convertiProductoDTO(entity);
        } else {
            return null;
        }
    }


    @Override
    public ProductoDTO guardarProducto(ProductoDTO productoDTO) {
        ProductoEntity entity = convertirAProductoEntity(productoDTO);
        return convertiProductoDTO(produtoRepository.save(entity));
    }

    @Override
    public ProductoDTO actualizarProducto(ProductoDTO productoDTO) {
        ProductoEntity entityExistente = produtoRepository.findById(productoDTO.getId_producto()).orElse(null);

        if (entityExistente != null) {
            entityExistente.setNombre(productoDTO.getNombre());
            entityExistente.setDescripcion(productoDTO.getDescripcion());
            entityExistente.setPrecio(BigDecimal.valueOf(productoDTO.getPrecio()));
            entityExistente.setStock(productoDTO.getStock());
            entityExistente.setCategoria(productoDTO.getCategoria());

            ProductoEntity actualizado = produtoRepository.save(entityExistente);
            return convertiProductoDTO(actualizado);
        } else {
            return null;
        }
    }

    @Override
    public void eliminarProducto(int id) {
        produtoRepository.deleteById(id);
    }

}
