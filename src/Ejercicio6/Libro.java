package Ejercicio6;

import java.io.Serializable;
import java.util.ArrayList;

/*
Cada libro tiene un título, uno o más autores, una editorial, un año de edición 
y formato (tapas duras o edición económica). 
Los libros tienen además un código ISBN y capítulos, los que tratan una o más
materias (en los técnicos) o es una simple división (en las novelas).
De cada libro se tiene un stock (que puede ser cero). Al 
venderse un libro, el stock se actualiza. 
 */
public abstract class Libro implements Serializable {

    private String isbn;
    private String titulo;
    private ArrayList<String> autores;
    private String editorial;
    private int anioEdicion;
    private TipoDeTapa formato;
    private int stock;

    public Libro(String isbn, String titulo, ArrayList<String> autores, String editorial, int anioEdicion, TipoDeTapa formato, int stock) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autores = autores;
        this.editorial = editorial;
        this.anioEdicion = anioEdicion;
        this.formato = formato;
        this.stock = stock;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ArrayList<String> getAutores() {
        return autores;
    }

    public void setAutores(ArrayList<String> autores) {
        this.autores = autores;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getAnioEdicion() {
        return anioEdicion;
    }

    public void setAnioEdicion(int anioEdicion) {
        this.anioEdicion = anioEdicion;
    }

    public TipoDeTapa getFormato() {
        return formato;
    }

    public void setFormato(TipoDeTapa formato) {
        this.formato = formato;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void vender() throws IllegalStateException {
        if (this.stock <= 0) {
            throw new IllegalStateException("Lo siento, no está disponible, haga un encargo.");
        }
        this.stock--;
    }

    public String toString() {
        return "Título: " + titulo + " | ISBN: " + isbn + "\nAutores: " + autores
                + "\nEditorial: " + editorial + " | Año: " + anioEdicion
                + "\nFormato: " + formato + " | Stock: " + stock;
    }
}
