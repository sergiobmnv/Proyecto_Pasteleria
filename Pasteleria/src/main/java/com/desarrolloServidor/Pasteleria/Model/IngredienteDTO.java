package com.desarrolloServidor.Pasteleria.Model;

import java.math.BigDecimal;

public class IngredienteDTO {

	private int id_ingrediente;
	private String nombre;
	private BigDecimal precio;
	private int stock;
	private String fabricante;
	
	
	public IngredienteDTO() {
		
	}


	public IngredienteDTO(int id_ingrediente, String nombre, BigDecimal precio, int stock, String fabricante) {
		
		this.id_ingrediente = id_ingrediente;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
		this.fabricante = fabricante;
	}


	public int getId_ingrediente() {
		return id_ingrediente;
	}


	public void setId_ingrediente(int id_ingrediente) {
		this.id_ingrediente = id_ingrediente;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public BigDecimal getPrecio() {
		return precio;
	}


	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	public String getFabricante() {
		return fabricante;
	}


	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	@Override
	public String toString() {
		return "IngredienteDTO [id_ingrediente=" + id_ingrediente + ", nombre=" + nombre + ", precio=" + precio
				+ ", stock=" + stock + ", fabricante=" + fabricante + "]";
	}
}