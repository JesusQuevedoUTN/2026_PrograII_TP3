package Ejercicio4;

import java.io.Serializable;

/*
Cada registro de la agenda cuenta con nombre, 
apellido, teléfono de linea, teléfono móvil, teléfono del trabajo, email y un 
campo que indique de donde conozco a la persona (trabajo, universidad, 
boliche…).
 */
public class Contacto implements Serializable {

    private static int contadorId = 0;

    private int id;
    private String nombre;
    private String apellido;
    private String telefonoDeLinea;
    private String telefonoMovil;
    private String telefonoDelTrabajo;
    private String email;
    private String contacto;

    public Contacto(int id, String nombre, String apellido, String telefonoDeLinea, String telefonoMovil, String telefonoDelTrabajo, String emaul, String contacto) {

        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefonoDeLinea = telefonoDeLinea;
        this.telefonoMovil = telefonoMovil;
        this.telefonoDelTrabajo = telefonoDelTrabajo;
        this.email = emaul;
        this.contacto = contacto;
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

    public String getTelefonoDeLinea() {
        return telefonoDeLinea;
    }

    public void setTelefonoDeLinea(String telefonoDeLinea) {
        this.telefonoDeLinea = telefonoDeLinea;
    }

    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    public String getTelefonoDelTrabajo() {
        return telefonoDelTrabajo;
    }

    public void setTelefonoDelTrabajo(String telefonoDelTrabajo) {
        this.telefonoDelTrabajo = telefonoDelTrabajo;
    }

    public String getEmaul() {
        return email;
    }

    public void setEmaul(String emaul) {
        this.email = emaul;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "----------------------------------------\n"
                + " ID: " + id + "\n"
                + " Nombre: " + nombre + " " + apellido + "\n"
                + " Móvil: " + telefonoMovil + "\n"
                + " Línea: " + telefonoDeLinea + "\n"
                + " Trabajo: " + telefonoDelTrabajo + "\n"
                + " Email: " + email + "\n"
                + " Origen: " + contacto + "\n"
                + "----------------------------------------";
    }

}
