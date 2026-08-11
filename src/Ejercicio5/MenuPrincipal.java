package Ejercicio5;

/*
Deberá contar con un menú para: 
- registrar
- eliminar
- buscar un registro
- mostrar todos.
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuPrincipal {

    private Scanner teclado;
    private GestorDeReserva gdr;

    public MenuPrincipal() {
        this.teclado = new Scanner(System.in);
        this.gdr = new GestorDeReserva();
    }

    public void menu() {
        int menu = -1;
        do {
            System.out.println("\n--- SISTEMA DE RESERVAS DE AUTOS ---");
            System.out.println("1. Registrar reserva");
            System.out.println("2. Registrar nuevo Cliente");
            System.out.println("3. Registrar nuevo auto");
            System.out.println("4. Mostrar todas las reservas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                menu = teclado.nextInt();
                teclado.nextLine();

                switch (menu) {
                    case 1:
                        registrarReserva();
                        break;
                    case 2:
                        registrarCliente();
                        break;
                    case 3:
                        registrarAuto();
                        break;
                    case 4:
                        gdr.mostrarReservas();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("El número ingresado es inválido.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número entero.");
                teclado.nextLine();
                menu = -1;
            }
        } while (menu != 0);
    }

    private void registrarCliente() {
        System.out.println("\n--- REGISTRAR NUEVO CLIENTE ---");

        System.out.print("Ingrese DNI: ");
        String dni = teclado.nextLine();

        System.out.print("Ingrese Código de cliente: ");
        String codigo = teclado.nextLine();

        System.out.print("Ingrese Nombre: ");
        String nombre = teclado.nextLine();

        System.out.print("Ingrese Apellido: ");
        String apellido = teclado.nextLine();

        System.out.print("Ingrese Dirección: ");
        String direccion = teclado.nextLine();

        System.out.print("Ingrese Teléfono: ");
        String telefono = teclado.nextLine();

        Cliente nuevoCliente = new Cliente(dni, nombre, apellido, direccion, telefono);
        gdr.agregarCliente(nuevoCliente);

        System.out.println("¡Cliente registrado con éxito!");
    }

    private void registrarAuto() {
        System.out.println("\n--- REGISTRAR NUEVO AUTO ---");
        System.out.print("Ingrese Matrícula: ");
        String matricula = teclado.nextLine();
        System.out.print("Ingrese Marca: ");
        String marca = teclado.nextLine();
        System.out.print("Ingrese Modelo: ");
        String modelo = teclado.nextLine();
        System.out.print("Ingrese Color: ");
        String color = teclado.nextLine();
        System.out.print("Ingrese Cantidad de plazas: ");
        int plazas = teclado.nextInt();
        System.out.print("Ingrese Precio de alquiler por día: ");
        double precio = teclado.nextDouble();
        teclado.nextLine(); // Limpiar buffer

        Auto nuevoAuto = new Auto(matricula, marca, modelo, color, plazas, precio);
        gdr.agregarAuto(nuevoAuto);
        System.out.println("¡Auto registrado con éxito!");
    }

    private void registrarReserva() {
        //Codigo hecho grcias a Gemini Pro
        
        System.out.println("\n--- REGISTRAR NUEVA RESERVA ---");

        // 1. Pedir ID del cliente (usamos gdr directamente)
        System.out.print("Ingrese ID del cliente: ");
        int idCliente = Integer.parseInt(teclado.nextLine());
        Cliente cliente = gdr.buscarClientePorId(idCliente); // <-- Cambiado aquí

        if (cliente == null) {
            System.out.println("Error: Cliente no encontrado.");
            return;
        }

        // 2. Seleccionar Auto por Matrícula (usamos gdr directamente)
        System.out.print("Ingrese Matrícula del auto a reservar: ");
        String matricula = teclado.nextLine();
        Auto auto = gdr.buscarAutoPorMatricula(matricula); // <-- Cambiado aquí

        if (auto == null) {
            System.out.println("Error: Auto no encontrado.");
            return;
        }

        ArrayList<Auto> autosElegidos = new ArrayList<>();
        autosElegidos.add(auto);

        // 3. Crear la Reserva y registrarla
        int idReserva = gdr.obtenerSiguienteId();
        Reserva nuevaReserva = new Reserva(idReserva, cliente, autosElegidos, new Date(), new Date());

        gdr.registrarReserva(nuevaReserva); 

        System.out.println("¡Reserva creada con éxito!");
    }

}
