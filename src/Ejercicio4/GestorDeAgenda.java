package Ejercicio4;

/*
Deberá contar con un menú para: 
- registrar
- eliminar
- buscar un registro
- mostrar todos.
 */
import java.util.ArrayList;
import java.io.*;

public class GestorDeAgenda {

    private ArrayList<Contacto> contactos;
    private static final String RUTA_DAT = "resources/agenda.dat";

    public GestorDeAgenda() {
        cargarDesdeArchivo();
    }

    public void registrarContacto(Contacto nuevoContacto) {
        contactos.add(nuevoContacto);
        guardarEnArchivo();
    }

    public void eliminarContacto(Contacto eliminar) {
        contactos.remove(eliminar);
        guardarEnArchivo();
    }

    public Contacto buscarContacto(int id) {
        int i = 0;
        Contacto buscado = null;

        while (i < contactos.size() && buscado == null) {
            Contacto posicionActual = contactos.get(i);
            if (posicionActual.getId() == id) {
                buscado = posicionActual;
            }
            i++;
        }
        return buscado;
    }

    void mostrarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("La agenda está vacía.");
        } else {
            for (Contacto c : contactos) {
                System.out.println(c);
            }
        }
    }

    private void guardarEnArchivo() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(RUTA_DAT))) {
            oos.writeObject(contactos);
        } catch (IOException e) {
            System.out.println("Error al guardar en el archivo: " + e.getMessage());
        }
    }

    private void cargarDesdeArchivo() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(RUTA_DAT))) {
            contactos = (ArrayList<Contacto>) ois.readObject();
        } catch (FileNotFoundException e) {
            // Es normal la primera vez que se ejecuta el programa, porque el archivo todavía no existe
            contactos = new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar los datos: " + e.getMessage());
            contactos = new ArrayList<>();
        }
    }

    public int obtenerSiguienteId() {
        if (contactos.isEmpty()) {
            return 0;
        }
        return contactos.get(contactos.size() - 1).getId() + 1;
    }
}
