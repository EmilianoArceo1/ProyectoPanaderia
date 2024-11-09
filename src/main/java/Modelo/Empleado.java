package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Empleado {
    private String nombre;
    private int id;
    private List<Pedido> pedidos;

    public Empleado(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
        this.pedidos = new ArrayList<>();
    }

    public List<Pedido> verPedidosPendientes() {
        List<Pedido> pendientes = new ArrayList<>();
        for (Pedido p : pedidos) {
            if (p.getEstado().equals("pendiente")) {
                pendientes.add(p);
            }
        }
        return pendientes;
    }

    public void actualizarEstadoPedido(Pedido p, String estado) {
        p.setEstado(estado);
    }

    public void agregarPedido(Pedido p) {
        pedidos.add(p);
    }
}
