package Ejercicio6;

import java.io.*;
import java.util.ArrayList;

public class Libreria implements Serializable {

    private ArrayList<Libro> libros;
    private ArrayList<Proveedor> proveedores;
    private static final String RUTA_ARCHIVO = "libreria.dat";

    public Libreria() {
        this.libros = new ArrayList<>();
        this.proveedores = new ArrayList<>();
        cargarDesdeArchivo();
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

    public void cargarDesdeArchivo() {
        File archivo = new File(RUTA_ARCHIVO);
        if (archivo.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
                Libreria cargada = (Libreria) ois.readObject();
                this.libros = cargada.getLibros();
                this.proveedores = cargada.getProveedores();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error al cargar datos: " + e.getMessage());
            }
        }
    }

    public void mostrarLibros() {
        for (Libro l : libros) {
            System.out.println(l.toString());
        }
    }

    public void mostrarProovedores() {
        for (Proveedor p : proveedores) {
            System.out.println(p.toString());
        }
    }

    public Libro buscarLibro(String aBuscar) {
        Libro encontrado = null;
        int i = 0;
        while (encontrado == null && i < libros.size()) {
            if (libros.get(i).getIsbn().equals(aBuscar)) {
                encontrado = libros.get(i);
            }
            i++;
        }
        return encontrado;
    }
}
