package Ejercicio5;

import java.io.Serializable;

/*
- De cada cliente se desean almacenar su DNI, nombre y apellido, dirección y 
teléfono. Además dos clientes se diferencian por un código único.
- Un determinado cliente puede tener en un momento dado hechas varias reservas.
- Una reserva la realiza un único cliente pero puede involucrar varios autos.
 */
public class Cliente implements Serializable {

    private static int contadorId = 0;

    private int id;

    private String dni;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;

    public Cliente(String dni, String nombre, String apellido, String direccion, String telefono) {
        this.id = contadorId++;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
