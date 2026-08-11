package Ejercicio5;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Agencia implements Serializable {

    private ArrayList<Cliente> clientes;
    private ArrayList<Auto> autos;
    private ArrayList<Reserva> reservas;

    public Agencia() {
        this.clientes = new ArrayList<>();
        this.autos = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public void registrarCliente(Cliente c) {
        clientes.add(c);
    }

    public void registrarAuto(Auto a) {
        autos.add(a);
    }

    public void hacerReserva(int id, Cliente cliente, ArrayList<Auto> autosElegidos, Date fInicio, Date fFin) {
        Reserva reserva = new Reserva(id, cliente, autosElegidos, fInicio, fFin);
        reservas.add(reserva);
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public ArrayList<Auto> getAutos() {
        return autos;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }
}
