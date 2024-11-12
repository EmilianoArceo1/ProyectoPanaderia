package Controlador;

import Modelo.Inventario;
import Modelo.Pedido;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author emili
 */
public class Controlador {
    private Inventario inventario;
    
    public Controlador(){
        inventario = new Inventario();
    }
    
    public List<String> getProductos(){
        List<String> nombreProductos = new ArrayList<>(getInventario().keySet());
        return nombreProductos;
    }
    
    public void agregarProducto(String producto, int cantidad){
        inventario.agregarProducto(producto, cantidad);
    }
    
    public void borrarProducto(String producto){
        inventario.borrarProducto(producto);
    }

    public Map<String, Integer> getInventario() {
        return inventario.getInventario();
    }

    public void actualizarProducto(String productoSeleccionado, String nuevoNombre, String cantidad) {
        inventario.cambiarNombreProducto(productoSeleccionado, nuevoNombre, Integer.parseInt(cantidad));
    }
    
    public void agregarPedido(Pedido pedido){
        inventario.levantarPedido(pedido);
    }
    
    public List<Pedido> getPedidos() {
        ArrayList<String> input = inventario.getPedidos(); 
        List<Pedido> pedidos = new ArrayList<>(); // Lista para almacenar los objetos Pedido

        for (String line : input) {
            int id = Integer.parseInt(line.split("id=")[1].split(",")[0].trim());
            String producto = line.split("producto=")[1].split(",")[0].trim();
            int cantidad = Integer.parseInt(line.split("cantidad=")[1].split(",")[0].trim());
            String estado = line.split("estado=")[1].split(",")[0].trim();
            String prioridad = line.split("prioridad=")[1].split("}")[0].trim();

            // Crear el objeto Pedido con todos los atributos
            Pedido pedido = new Pedido(id, producto, cantidad);
            pedidos.add(pedido);
        }

        return pedidos;
    }

}
