package Modelo;

import java.util.Date;
import java.sql.Time;

public class Pedido {
    private int id;
    private String producto;
    private int cantidad;
    private Date fechaEntrega;
    private Time horaEntrega;
    private String estado;
    private String prioridad;

    public Pedido(int id, String producto, int cantidad, Date fechaEntrega, Time horaEntrega) {
        this.id = id;
        this.producto = producto;
        this.cantidad = cantidad;
        this.fechaEntrega = fechaEntrega;
        this.horaEntrega = horaEntrega;
        this.estado = "pendiente";
        this.prioridad = "normal";
    }

    public void marcarEnProceso() {
        this.estado = "en proceso";
    }

    public void completarPedido() {
        this.estado = "completado";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Time getHoraEntrega() {
        return horaEntrega;
    }

    public void setHoraEntrega(Time horaEntrega) {
        this.horaEntrega = horaEntrega;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }
}
