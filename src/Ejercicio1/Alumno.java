package Ejercicio1;

public class Alumno {

    private static int contadorId = 1;

    private int id;
    private String nombre;

    public Alumno(String nombre) {
        this.id = contadorId++;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Alumno{" + "id=" + id + ", nombre=" + nombre + '}';
    }

}
