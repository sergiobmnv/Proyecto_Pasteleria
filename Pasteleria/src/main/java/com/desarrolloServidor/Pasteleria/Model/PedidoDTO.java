package com.desarrolloServidor.Pasteleria.Model;

public class PedidoDTO {

	private Integer idPedido;
    private String pendiente;
    private String entregado;
    private Integer idProducto;
    private Integer idCliente;
	private int cantidad;

    public PedidoDTO() {
    }

    public PedidoDTO(int cantidad, String entregado, Integer idCliente, Integer idPedido, Integer idProducto, String pendiente) {
        this.cantidad = cantidad;
        this.entregado = entregado;
        this.idCliente = idCliente;
        this.idPedido = idPedido;
        this.idProducto = idProducto;
        this.pendiente = pendiente;
    }

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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    

}