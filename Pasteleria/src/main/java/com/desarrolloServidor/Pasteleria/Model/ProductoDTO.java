package com.desarrolloServidor.Pasteleria.Model;

import java.util.List;

public class ProductoDTO {

	private int id_producto;
    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;
    private String categoria;
    private List<String> ingredientes;

    public ProductoDTO() {
    }

    public ProductoDTO(String categoria, String descripcion, int id_producto, List<String> ingredientes, String nombre, double precio, int stock) {

        this.categoria = categoria;
        this.descripcion = descripcion;
        this.id_producto = id_producto;
        this.ingredientes = ingredientes;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

	public int getId_producto() {
		return id_producto;
	}

	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public List<String> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<String> ingredientes) {
		this.ingredientes = ingredientes;
	}
	
}