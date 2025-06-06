package com.desarrolloServidor.Pasteleria.Entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cliente")
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLIENTE", nullable = false)
    private Integer idCliente;

    @Column(name = "NOMBRE", nullable = false, length = 45)
    private String nombre;

    @Column(name = "APELLIDOS", nullable = false, length = 50)
    private String apellidos;

    @Column(name = "DIRECCION", nullable = false, length = 45)
    private String direccion;

    @Column(name = "CONTRASENIA", nullable = false, length = 45)
    private String contrasenia;

    @Column(name = "FECHA_NAC", nullable = false)
    private LocalDate fechanac;

    @Column(name = "PRODUCTO", length = 45)
    private String producto;

    @Column(name = "EMAIL", nullable = false, length = 45)
    private String email;

    @Column(name = "TELEFONO", nullable = false, length = 45)
    private String telefono;

    @Column(name = "PRECIO_PEDIDO", precision = 8, scale = 2)
    private BigDecimal precioPedido;

    @Column(name = "OBSERVACIONES", length = 45)
    private String observaciones;

    @Column(name = "ES_USUARIO", nullable = false)
    private boolean esUsuario;

    @Column(name = "ES_EMPLEADO", nullable = false)
    private boolean esEmpleado;

    // Getters y Setters
    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
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

    public LocalDate getFechaNac() {
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

    public BigDecimal getPrecioPedido() {
        return precioPedido;
    }

    public void setPrecioPedido(BigDecimal precioPedido) {
        this.precioPedido = precioPedido;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public LocalDate getFechanac() {
        return fechanac;
    }

	public boolean isEsUsuario() {
		return esUsuario;
	}

	public void setEsUsuario(boolean esUsuario) {
		this.esUsuario = esUsuario;
	}

	public boolean isEsEmpleado() {
		return esEmpleado;
	}

	public void setEsEmpleado(boolean esEmpleado) {
		this.esEmpleado = esEmpleado;
	}

    

}
