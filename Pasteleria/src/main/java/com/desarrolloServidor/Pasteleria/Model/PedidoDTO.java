package com.desarrolloServidor.Pasteleria.Model;

public class PedidoDTO {

	private Integer idPedido;
    private String pendiente;
    private String entregado;
    private Integer idProducto;
    private Integer idCliente;
    
// Constructor Vacio.
	public PedidoDTO() {

	}

// Constructor Con datos de la tabla.
	public PedidoDTO(Integer idPedido, String pendiente, String entregado, Integer idProducto, Integer idCliente) {
		
		this.idPedido = idPedido;
		this.pendiente = pendiente;
		this.entregado = entregado;
		this.idProducto = idProducto;
		this.idCliente = idCliente;
	}
	

// Getters y Setters.

	public Integer getIdPedido() {
		return idPedido;
	}


	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}


	public String getPendiente() {
		return pendiente;
	}


	public void setPendiente(String pendiente) {
		this.pendiente = pendiente;
	}


	public String getEntregado() {
		return entregado;
	}


	public void setEntregado(String entregado) {
		this.entregado = entregado;
	}


	public Integer getIdProducto() {
		return idProducto;
	}


	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}


	public Integer getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}


	@Override
	public String toString() {
		return "PedidoDTO [idPedido=" + idPedido + ", pendiente=" + pendiente + ", entregado=" + entregado
				+ ", idProducto=" + idProducto + ", idCliente=" + idCliente + "]";
	}	
}