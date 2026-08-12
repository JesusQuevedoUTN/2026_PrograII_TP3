package Ejercicio4;

/*
Deberá contar con un menú para: 
- registrar
- eliminar
- buscar un registro
- mostrar todos.
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuPrincipal {

    private Scanner teclado;
    private GestorDeAgenda gda;

    public MenuPrincipal() {
        this.teclado = new Scanner(System.in);
        this.gda = new GestorDeAgenda();
    }

    public void menu() {
        int menu = -1;
        do {
            System.out.println("\n--- CONTACTOS ---");
            System.out.println("1. Registrar contacto");
            System.out.println("2. Eliminar contacto");
            System.out.println("3. Buscar contacto");
            System.out.println("4. Mostrar todos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                menu = teclado.nextInt();
                teclado.nextLine();

                switch (menu) {
                    case 1:
                        crearContacto();
                        break;
                    case 2:
                        Contacto eliminar = buscarContacto();
                        if (eliminar == null) {
                            System.out.println("No existe el contacto");
                        } else {
                            gda.eliminarContacto(eliminar);

                        }
                        break;
                    case 3:
                        Contacto buscado = buscarContacto();
                        if (buscado == null) {
                            System.out.println("No existe el contacto");
                        } else {
                            System.out.println(buscado);

                        }
                        break;
                    case 4:
                        gda.mostrarContactos();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("El numero ingresado es invalido");
                }

            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número entero.");
                teclado.nextLine();
                menu = -1;
            }
        } while (menu != 0);

    }

    private void crearContacto() {
        System.out.println("\n--- REGISTRAR NUEVO CONTACTO ---");

        System.out.print("Ingrese nombre: ");
        String nombre = teclado.nextLine();

        System.out.print("Ingrese apellido: ");
        String apellido = teclado.nextLine();

        System.out.print("Ingrese teléfono de línea: ");
        String linea = teclado.nextLine();

        System.out.print("Ingrese teléfono móvil: ");
        String movil = teclado.nextLine();

        System.out.print("Ingrese teléfono del trabajo: ");
        String trabajo = teclado.nextLine();

        System.out.print("Ingrese email: ");
        String email = teclado.nextLine();

        System.out.print("Ingrese origen/contacto (ej: trabajo, universidad): ");
        String origen = teclado.nextLine();

        int id = gda.obtenerSiguienteId();

        Contacto nuevo = new Contacto(id, nombre, apellido, linea, movil, trabajo, email, origen);
        gda.registrarContacto(nuevo);
    }

    private Contacto buscarContacto() {
        System.out.print("Ingrese el ID a buscar: ");
        int id = teclado.nextInt();
        teclado.nextLine();

        return gda.buscarContacto(id);
    }

}
