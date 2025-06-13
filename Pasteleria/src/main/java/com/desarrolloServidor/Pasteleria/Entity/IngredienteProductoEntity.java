package com.desarrolloServidor.Pasteleria.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "INGREDIENTE_PRODUCTO")
public class IngredienteProductoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_INGREDIENTE_PRODUCTO")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "ID_INGREDIENTE", nullable = false)
    private IngredienteEntity ingrediente;

    @ManyToOne
    @JoinColumn(name = "ID_PRODUCTO", nullable = false)
    private ProductoEntity producto;

    @Column(name = "CANTIDAD_NECESARIA", nullable = false)
    private Integer cantidadNecesaria;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public IngredienteEntity getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(IngredienteEntity ingrediente) {
        this.ingrediente = ingrediente;
    }

    public ProductoEntity getProducto() {
        return producto;
    }

    public void setProducto(ProductoEntity producto) {
        this.producto = producto;
    }

    public Integer getCantidadNecesaria() {
        return cantidadNecesaria;
    }

    public void setCantidadNecesaria(Integer cantidadNecesaria) {
        this.cantidadNecesaria = cantidadNecesaria;
    }

    

}
