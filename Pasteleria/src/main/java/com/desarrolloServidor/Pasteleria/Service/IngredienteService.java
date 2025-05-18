package com.desarrolloServidor.Pasteleria.Service;

import java.util.List;

import com.desarrolloServidor.Pasteleria.Model.IngredienteDTO;

public interface  IngredienteService {
    
    List<IngredienteDTO> listarIngredientes();
    IngredienteDTO obtenerIngredientePorId(Integer id);
    IngredienteDTO registrarIngrediente(IngredienteDTO ingredienteDTO);
    IngredienteDTO actualizarIngrediente(Integer id, IngredienteDTO ingredienteDTO);
    void eliminarIngrediente(Integer id);
    
}
