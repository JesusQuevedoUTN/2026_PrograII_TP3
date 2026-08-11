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
            total += a.getPrecioAlquiler(); // Asumiendo que Auto tiene getPrecioAlquiler()
        }
        return total;
    }

    @Override
    public String toString() {
        //Hecho con gemini
        StringBuilder sb = new StringBuilder();
        sb.append("========================================\n");
        sb.append(" RESERVA #").append(id).append("\n");
        sb.append("========================================\n");
        sb.append(" Cliente: ").append(cliente.getNombre()).append(" ").append(cliente.getApellido());
        sb.append(" (DNI: ").append(cliente.getDni()).append(")\n");
        sb.append(" Fechas: ").append(fechaInicio).append(" al ").append(fechaFinal).append("\n");
        sb.append(" Estado: ").append(entregado ? "Entregado" : "Pendiente de entrega").append("\n");
        sb.append(" Autos alquilados:\n");
        for (Auto a : autos) {
            sb.append("   - ").append(a.getMarca()).append(" ").append(a.getModelo());
            sb.append(" [Matrícula: ").append(a.getMatricula()).append("] - $").append(a.getPrecioAlquiler()).append("\n");
        }
        sb.append("----------------------------------------\n");
        sb.append(" PRECIO TOTAL: $").append(calcularPrecioTotal()).append("\n");
        sb.append("========================================\n");
        return sb.toString();
    }
}
