package Ejercicio6;

import java.io.*;
import java.util.ArrayList;

public class Libreria implements Serializable {

    private ArrayList<Libro>        libros;
    private ArrayList<Proveedor>    proveedores;
    private static final String RUTA_ARCHIVO = "libreria.dat";

    public Libreria() {
        this.libros = new ArrayList<>();
        this.proveedores = new ArrayList<>();
    }

    public void agregarLibro(Libro l) {
        libros.add(l);
        guardarEnArchivo();
    }

    public void agregarProveedor(Proveedor p) {
        proveedores.add(p);
        guardarEnArchivo();
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public ArrayList<Proveedor> getProveedores() {
        return proveedores;
    }

    public void guardarEnArchivo() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(RUTA_ARCHIVO))) {
            oos.writeObject(this);
        } catch (IOException e) {
            System.out.println("Error al guardar datos: " + e.getMessage());
        }
    }

    
}
