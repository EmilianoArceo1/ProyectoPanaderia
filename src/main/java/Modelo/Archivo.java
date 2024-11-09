package Modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author emili
 */
public class Archivo {
    private String ruta;
    private File archivo;
    private int cantidad;

    public Archivo(String ruta) {
        this.ruta = ruta;
        archivo = new File(ruta);
        crearArchivo();
    }
    
    //Reescribe lo que hay en el archivo
    public void guardarDatos(String datos) {
        try {
            // El true permite agregar al final del archivo
            FileWriter escritor = new FileWriter(archivo, true);  
            escritor.write(datos + "\n");
            escritor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Extrae lo que hay en el archivo
    public ArrayList<String> leerDatos(){
        cantidad = 0;
        ArrayList<String> datos = new ArrayList<>();
        try {
            BufferedReader lector = new BufferedReader(new FileReader(ruta));
            String linea;
            while ((linea = lector.readLine()) != null) {
                datos.add(linea);
                cantidad++;
            }
            lector.close();
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no fue encontrado, se creará uno nuevo.");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo.");
            e.printStackTrace();
        }

        return datos;
    }
    
    //Verifica si existe un archivo y lo crea en caso de que no
    public void crearArchivo(){
        try {
            if (archivo.exists()) {
                System.out.println("El archivo ya existe.");
            } else {
                // Intentar crear el archivo
                if (archivo.createNewFile()) {
                    System.out.println("El archivo ha sido creado exitosamente.");
                } else {
                    System.out.println("No se pudo crear el archivo.");
                }
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al crear el archivo.");
            e.printStackTrace();
        }
    }
    
    //Deja el documento en blanco
    public void eliminarDatos(){
        try {
            FileWriter escritor = new FileWriter(archivo);
            escritor.close();
            System.out.println("El contenido del archivo ha sido eliminado.");
            cantidad = 0;
        } catch (IOException e) {
            System.out.println("Ocurrió un error al vaciar el archivo.");
            e.printStackTrace();
        }
    }
    
    public boolean esArchivoVacio() {
        return archivo.length() == 0;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
    
    public int cantidad(){
        return cantidad;
    }
}
