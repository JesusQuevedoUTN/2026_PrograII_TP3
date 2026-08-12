package Ejercicio6;

import java.util.ArrayList;

public class LibroTecnico extends Libro {

    private CategoriaTecnico area;

    public LibroTecnico(String isbn, String titulo, ArrayList<String> autores, String editorial, int anioEdicion, TipoDeTapa formato, int stock, CategoriaTecnico area) {
        super(isbn, titulo, autores, editorial, anioEdicion, formato, stock);
        this.area = area;
    }

    public CategoriaTecnico getArea() {
        return area;
    }

    public void setArea(CategoriaTecnico area) {
        this.area = area;
    }

}
