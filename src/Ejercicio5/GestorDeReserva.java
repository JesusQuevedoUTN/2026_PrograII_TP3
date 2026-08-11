package Ejercicio5;

import java.io.*;
import java.util.ArrayList;

public class GestorDeReserva {

    private ArrayList<Reserva> reservas;
    private ArrayList<Cliente> clientes;
    private ArrayList<Auto> autos;
    private static final String RUTA_DAT = "resources/reservas.dat";

    public GestorDeReserva() {
        this.clientes = new ArrayList<>();
        this.autos = new ArrayList<>();
        this.reservas = new ArrayList<>();
        cargarDesdeArchivo();
    }

    public void registrarReserva(Reserva nuevaReserva) {
        reservas.add(nuevaReserva);
        guardarEnArchivo();
    }

    public void agregarCliente(Cliente c) {
        clientes.add(c);
        guardarEnArchivo();
    }

    public void agregarAuto(Auto a) {
        autos.add(a);
        guardarEnArchivo();
    }

    public void mostrarReservas() {
        if (reservas.isEmpty()) {
            System.out.println("No hay reservas registradas.");
        } else {
            for (Reserva r : reservas) {
                System.out.println(r);
            }
        }
    }

    public int obtenerSiguienteId() {
        if (reservas.isEmpty()) {
            return 0;
        }
        return reservas.get(reservas.size() - 1).getId() + 1;
    }

    private void guardarEnArchivo() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(RUTA_DAT))) {
            oos.writeObject(reservas);
            oos.writeObject(clientes);
            oos.writeObject(autos);
        } catch (IOException e) {
            System.out.println("Error al guardar en el archivo: " + e.getMessage());
        }
    }

    private void cargarDesdeArchivo() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(RUTA_DAT))) {
            reservas = (ArrayList<Reserva>) ois.readObject();
            clientes = (ArrayList<Cliente>) ois.readObject();
            autos = (ArrayList<Auto>) ois.readObject();
        } catch (FileNotFoundException e) {
            reservas = new ArrayList<>();
            clientes = new ArrayList<>();
            autos = new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar los datos: " + e.getMessage());
            reservas = new ArrayList<>();
            clientes = new ArrayList<>();
            autos = new ArrayList<>();
        }
    }

    public Cliente buscarClientePorId(int id) {
        Cliente aBuscar = null;
        for (Cliente c : clientes) {
            if (c.getId() == id) {
                aBuscar = c;
            }
        }
        return aBuscar;
    }

    public Auto buscarAutoPorMatricula(String matricula) {
        Auto aBuscar = null;
        for (Auto a : autos) {
            if (a.getMatricula().equalsIgnoreCase(matricula)) {
                aBuscar = a;
            }
        }
        return aBuscar;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Auto> getAutos() {
        return autos;
    }

    public void setAutos(ArrayList<Auto> autos) {
        this.autos = autos;
    }

}
