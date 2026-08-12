package Ejercicio6;

import java.util.ArrayList;

public class Novela extends Libro {

    private CategoriaNovela genero;

    public Novela(String isbn, String titulo, ArrayList<String> autores, String editorial, int anioEdicion, TipoDeTapa formato, int stock, CategoriaNovela genero) {
        super(isbn, titulo, autores, editorial, anioEdicion, formato, stock);
        this.genero = genero;
    }

    public CategoriaNovela getGenero() {
        return genero;
    }

    public void setGenero(CategoriaNovela genero) {
        this.genero = genero;
    }

}
