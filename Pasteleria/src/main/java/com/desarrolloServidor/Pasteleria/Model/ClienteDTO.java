package com.desarrolloServidor.Pasteleria.Model;

import java.time.LocalDate;

public class ClienteDTO {

	private Integer id_cliente;
	private String nombre;
	private String apellidos;
	private String direccion;
	private String contrasenia;
	private LocalDate fechanac;
	private String producto;
	private String email;
	private String telefono;
	private Double precio_pedido;
	private String observacion;
	
	public ClienteDTO() {
		
	}


	public ClienteDTO(Integer id_cliente, String nombre, String apellidos, String direccion, String contrasenia,
			LocalDate fechanac, String producto, String email, String telefono, Double precio_pedido,
			String observacion) {
		
		this.id_cliente = id_cliente;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.contrasenia = contrasenia;
		this.fechanac = fechanac;
		this.producto = producto;
		this.email = email;
		this.telefono = telefono;
		this.precio_pedido = precio_pedido;
		this.observacion = observacion;
	}

//Getters y Setters.
	
	public Integer getId_cliente() {
		return id_cliente;
	}


	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getContrasenia() {
		return contrasenia;
	}


	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}


	public LocalDate getFechanac() {
		return fechanac;
	}


	public void setFechanac(LocalDate fechanac) {
		this.fechanac = fechanac;
	}


	public String getProducto() {
		return producto;
	}


	public void setProducto(String producto) {
		this.producto = producto;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public Double getPrecio_pedido() {
		return precio_pedido;
	}


	public void setPrecio_pedido(Double precio_pedido) {
		this.precio_pedido = precio_pedido;
	}


	public String getObservacion() {
		return observacion;
	}


	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	@Override
	public String toString() {
		return "ClienteDTO [id_cliente=" + id_cliente + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", direccion=" + direccion + ", contrasenia=" + contrasenia + ", fecha_nac=" + fechanac
				+ ", producto=" + producto + ", email=" + email + ", numero_telefono=" + telefono
				+ ", precio_pedido=" + precio_pedido + ", observacion=" + observacion + "]";
	}
}