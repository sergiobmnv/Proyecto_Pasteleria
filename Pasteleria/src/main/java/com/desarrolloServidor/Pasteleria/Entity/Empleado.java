package com.desarrolloServidor.Pasteleria.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "EMPLEADO")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_EMPLEADO")
    private Long id;

    @Column(name = "NOMBRE", nullable = false, length = 45)
    private String nombre;

    @Column(name = "APELLIDO", nullable = false, length = 45)
    private String apellido;

    @Column(name = "TELEFONO", nullable = false, length = 45)
    private String telefono;

    @Column(name = "FECHA_CONTRATACION", nullable = false)
    private LocalDateTime fechaContratacion;

    @Column(name = "FECHA_ENTRADA", nullable = false)
    private LocalDateTime fechaEntrada;

    @Column(name = "FECHA_SALIDA", nullable = false)
    private LocalDateTime fechaSalida;

    // Campos nuevos para login
    @Column(name = "USERNAME", nullable = false, unique = true, length = 45)
    private String username;

    @Column(name = "PASSWORD", nullable = false, length = 255)
    private String password;

    @Column(name = "ROL", nullable = false, length = 20)
    private String rol;

    // Constructor vacío
    public Empleado() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public LocalDateTime getFechaContratacion() {
		return fechaContratacion;
	}

	public void setFechaContratacion(LocalDateTime fechaContratacion) {
		this.fechaContratacion = fechaContratacion;
	}

	public LocalDateTime getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(LocalDateTime fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public LocalDateTime getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(LocalDateTime fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
}