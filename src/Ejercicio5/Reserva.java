package Ejercicio5;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/*
- Un determinado cliente puede tener en un momento dado hechas varias reservas.
- Una reserva la realiza un único cliente pero puede involucrar varios autos.

- Es importante registrar: 
fecha de inicio 
final de la reserva
el precio del alquiler de cada uno de los autos
el precio total de la reserva
un indicador de si el auto o los autos han sido entregados.
 */
public class Reserva implements Serializable {

    private int id;
    private Cliente cliente;
    private ArrayList<Auto> autos;
    private Date fechaInicio;
    private Date fechaFinal;
    private boolean entregado;

    public Reserva(int id, Cliente cliente, ArrayList<Auto> autos, Date fechaInicio, Date fechaFinal) {
        this.id = id;
        this.cliente = cliente;
        this.autos = autos;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.entregado = false;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public boolean isEntregado() {
        return entregado;
    }

    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrecioTotal() {
        double total = 0;
        for (Auto a : autos) {
            total += a.getPrecioAlquiler();
        }
        return total;
    }

    public double calcularPrecioTotal() {
        double total = 0;
        for (Auto a : autos) {
            total += a.getPrecioAlquiler();
        }
        return total;
    }

    @Override
    public String toString() {
        return "RESERVA #" + id + "\n"
                + "Cliente: " + cliente.getNombre() + " " + cliente.getApellido() + "\tDNI: " + cliente.getDni() + "\n"
                + " Fechas: " + fechaInicio + " al " + fechaFinal + "\n"
                + " Estado: " + (entregado ? "Entregado" : "Pendiente de entrega") + "\n"
                + " Autos alquilados:\n" + autos.toString() + "\n"
                + " PRECIO TOTAL: $" + calcularPrecioTotal() + "\n";

    }
}
