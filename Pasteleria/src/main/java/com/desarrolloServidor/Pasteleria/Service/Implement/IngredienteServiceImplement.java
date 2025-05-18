package com.desarrolloServidor.Pasteleria.Service.Implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desarrolloServidor.Pasteleria.Entity.IngredienteEntity;
import com.desarrolloServidor.Pasteleria.Model.IngredienteDTO;
import com.desarrolloServidor.Pasteleria.Repository.IngredienteRepository;
import com.desarrolloServidor.Pasteleria.Service.IngredienteService;

@Service
public class IngredienteServiceImplement implements IngredienteService {

    @Autowired
    private IngredienteRepository ingredienteRepository;

    private IngredienteDTO convertirAIngredienteDTO(IngredienteEntity entity) {
        IngredienteDTO dto = new IngredienteDTO();

        dto.setId_ingrediente(entity.getIdIngrediente());
        dto.setNombre(entity.getNombre());
        dto.setPrecio(entity.getPrecio());
        dto.setStock(entity.getStock());
        dto.setFabricante(entity.getFabricante());
        return dto;
    }

    private IngredienteEntity convertirAIngredienteEntity(IngredienteDTO dto) {
    IngredienteEntity entity = new IngredienteEntity();

    // Modifica el método para solo establecer el ID si viene con un valor positivo (mayor que 0)
    if (dto.getId_ingrediente() > 0) {
        entity.setIdIngrediente(dto.getId_ingrediente());
    }
    entity.setNombre(dto.getNombre());
    entity.setPrecio(dto.getPrecio());
    entity.setStock(dto.getStock());
    entity.setFabricante(dto.getFabricante());
    return entity;
}


    @Override
    public List<IngredienteDTO> listarIngredientes() {
        List<IngredienteEntity> entidades = ingredienteRepository.findAll();
        List<IngredienteDTO> dtos = new ArrayList<>();

        for (IngredienteEntity entity : entidades) {
            IngredienteDTO dto = convertirAIngredienteDTO(entity);
            dtos.add(dto);
        }

        return dtos;
    }

    @Override
    public IngredienteDTO obtenerIngredientePorId(Integer id) {
        IngredienteEntity entity = ingredienteRepository.findById(id).orElse(null);

        if (entity != null) {
            return convertirAIngredienteDTO(entity);
        } else {
            return null;
        }
    }

    @Override
    public IngredienteDTO registrarIngrediente(IngredienteDTO ingredienteDTO) {
        IngredienteEntity entity = convertirAIngredienteEntity(ingredienteDTO);
        return convertirAIngredienteDTO(ingredienteRepository.save(entity));
    }

    @Override
    public IngredienteDTO actualizarIngrediente(Integer id, IngredienteDTO ingredienteDTO) {
        IngredienteEntity entity = ingredienteRepository.findById(id).orElse(null);

        if (entity != null) {
            entity.setNombre(ingredienteDTO.getNombre());
            entity.setPrecio(ingredienteDTO.getPrecio());
            entity.setStock(ingredienteDTO.getStock());
            entity.setFabricante(ingredienteDTO.getFabricante());

            IngredienteEntity actualizado = ingredienteRepository.save(entity);
            return convertirAIngredienteDTO(actualizado);
        } else {
            return null;
        }
    }

    @Override
    public void eliminarIngrediente(Integer id) {
        ingredienteRepository.deleteById(id);
    }

}
