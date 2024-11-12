package Modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Inventario {
    private Map<String, Integer> productos;
    private Archivo inventario;
    private Archivo pedidos;

    public Inventario() {
        inventario = new Archivo("inventario.txt");
        pedidos = new Archivo("pedidos.txt");
        productos = new HashMap<>(); 
        if(!inventario.esArchivoVacio()){
            llenarInventario(inventario.leerDatos());
        }
    }
    
    public void llenarInventario(ArrayList<String> datos){
        ArrayList<String> lineas = datos;

        // Recorrer cada línea
        for (String linea : lineas) {
            // Dividir cada línea en producto y cantidad
            String[] partes = linea.split(" ");
            String producto = partes[0];
            int cantidad = Integer.parseInt(partes[1]);

            // Guardar en el HashMap
            productos.put(producto, cantidad);
        }
    }

    public boolean verificarDisponibilidad(String producto, int cantidad) {
        return productos.getOrDefault(producto, 0) >= cantidad;
    }

    public void actualizarInventario(String producto, int cantidad) {
        productos.put(producto, productos.getOrDefault(producto, 0) + cantidad);
        actualizarArchivo();
    }

    public void cambiarNombreProducto(String nombreAntiguo, String nuevoNombre, int cantidad) {
        productos.remove(nombreAntiguo);
        productos.put(nuevoNombre, cantidad);
        actualizarArchivo();
    }

    // Método para agregar productos al inventario
    public void agregarProducto(String producto, int cantidad) {
        productos.put(producto, cantidad);
        actualizarArchivo();
    }
    
     public void borrarProducto(String producto) {
        if (productos.containsKey(producto)) {
            productos.remove(producto);
            inventario.eliminarDatos();  // Eliminar los datos del archivo
            actualizarArchivo();         // Escribir los datos actualizados

            System.out.println("Producto '" + producto + "' eliminado del inventario.");
        } else {
            System.out.println("El producto '" + producto + "' no existe en el inventario.");
        }
    }

     
    public void levantarPedido(Pedido pedido){
        pedidos.guardarDatos(pedido.toString());
    }
    
    public ArrayList<String> getPedidos(){
        return pedidos.leerDatos();
    }
    
    private void actualizarArchivo() {
        inventario.eliminarDatos();
        for (Map.Entry<String, Integer> entry : productos.entrySet()) {
            String linea = entry.getKey() + " " + entry.getValue();
            inventario.guardarDatos(linea);
        }
    }
    

    public Map<String, Integer> getInventario() {
        return productos;
    }
}
