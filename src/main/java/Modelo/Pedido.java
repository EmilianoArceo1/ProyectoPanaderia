package Modelo;

public class Pedido {
    private int id;
    private String producto;
    private int cantidad;
    private String estado;
    private String prioridad;

    public Pedido(int id, String producto, int cantidad) {
        this.id = id;
        this.producto = producto;
        this.cantidad = cantidad;
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

    @Override
    public String toString() {
        return "Pedido{" + "id=" + id + ", producto=" + producto + ", cantidad=" + cantidad + ", estado=" + estado + ", prioridad=" + prioridad + '}';
    }
}
