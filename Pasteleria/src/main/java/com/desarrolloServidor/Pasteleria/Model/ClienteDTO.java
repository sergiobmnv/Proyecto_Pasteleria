package com.desarrolloServidor.Pasteleria.Model;

import java.util.Date;

public class ClienteDTO {

	private int id_cliente;
	private String nombre;
	private String apellidos;
	private String direccion;
	private String contrasenia;
	private Date fechanac;
	private String producto;
	private String email;
	private String telefono;
	private Double precio_pedido;
	private String observacion;
	private String estado;
	
	
	public ClienteDTO() {
		
	}


	public ClienteDTO(int id_cliente, String nombre, String apellidos, String direccion, String contrasenia,
			Date fechanac, String producto, String email, String telefono, Double precio_pedido,
			String observacion, String estado) {
		
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
		this.estado = estado;
	}

//Getters y Setters.
	
	public int getId_cliente() {
		return id_cliente;
	}


	public void setId_cliente(int id_cliente) {
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


	public Date getFechanac() {
		return fechanac;
	}


	public void setFechanac(Date fechanac) {
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


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "ClienteDTO [id_cliente=" + id_cliente + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", direccion=" + direccion + ", contrasenia=" + contrasenia + ", fecha_nac=" + fechanac
				+ ", producto=" + producto + ", email=" + email + ", numero_telefono=" + telefono
				+ ", precio_pedido=" + precio_pedido + ", observacion=" + observacion + ", estado=" + estado + "]";
	}
}