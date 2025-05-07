package com.desarrolloServidor.Pasteleria.Model;

import java.util.Date;

public class EmpleadoDTO {

	private int id_empleado;
	private String nombre;
	private String apellido;
	private String telefono;
	private Date fecha_contratacion;
	private Date fecha_entrada;
	private Date fecha_salida;
	
	
	public EmpleadoDTO() {
		
	}


	public EmpleadoDTO(int id_empleado, String nombre, String apellido, String telefono, Date fecha_contratacion,
			Date fecha_entrada, Date fecha_salida) {
		
		this.id_empleado = id_empleado;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.fecha_contratacion = fecha_contratacion;
		this.fecha_entrada = fecha_entrada;
		this.fecha_salida = fecha_salida;
	}


	public int getId_empleado() {
		return id_empleado;
	}


	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public Date getFecha_contratacion() {
		return fecha_contratacion;
	}


	public void setFecha_contratacion(Date fecha_contratacion) {
		this.fecha_contratacion = fecha_contratacion;
	}


	public Date getFecha_entrada() {
		return fecha_entrada;
	}


	public void setFecha_entrada(Date fecha_entrada) {
		this.fecha_entrada = fecha_entrada;
	}


	public Date getFecha_salida() {
		return fecha_salida;
	}


	public void setFecha_salida(Date fecha_salida) {
		this.fecha_salida = fecha_salida;
	}


	@Override
	public String toString() {
		return "EmpleadoDTO [id_empleado=" + id_empleado + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", telefono=" + telefono + ", fecha_contratacion=" + fecha_contratacion + ", fecha_entrada="
				+ fecha_entrada + ", fecha_salida=" + fecha_salida + "]";
	}
}