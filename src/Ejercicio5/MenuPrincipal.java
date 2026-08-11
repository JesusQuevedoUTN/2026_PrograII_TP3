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
        //HECHO CON GEMINI
        
        System.out.println("\n--- REGISTRAR NUEVA RESERVA ---");

        // 1. Mostrar y seleccionar Cliente
        System.out.println("\n--- CLIENTES DISPONIBLES ---");
        for (Cliente c : gdr.getClientes()) {
            System.out.println("ID/Código: " + c.getId() + " - Nombre: " + c.getNombre() + " " + c.getApellido());
        }

        System.out.print("Ingrese ID del cliente: ");
        int idCliente = Integer.parseInt(teclado.nextLine());
        Cliente cliente = gdr.buscarClientePorId(idCliente);

        if (cliente == null) {
            System.out.println("Error: Cliente no encontrado.");
            return;
        }

        // 2. Cargar Autos mediante bucle (1: Sí / 0: No)
        ArrayList<Auto> autosElegidos = new ArrayList<>();
        int continuar = 0;

        do {
            System.out.println("\n--- AUTOS DISPONIBLES ---");
            for (Auto a : gdr.getAutos()) {
                System.out.println("Matrícula: " + a.getMatricula() + " - Marca: " + a.getMarca() + " - Modelo: " + a.getModelo());
            }

            System.out.print("Ingrese Matrícula del auto a reservar: ");
            String matricula = teclado.nextLine();
            Auto auto = gdr.buscarAutoPorMatricula(matricula);

            if (auto != null) {
                autosElegidos.add(auto);
                System.out.println("¡Auto agregado con éxito!");
            } else {
                System.out.println("Error: Auto no encontrado.");
            }

            System.out.print("¿Desea agregar otro auto a esta reserva? (1: Sí / 0: No): ");
            continuar = Integer.parseInt(teclado.nextLine());

        } while (continuar == 1);

        // Validación por si no eligió ningún auto válido
        if (autosElegidos.isEmpty()) {
            System.out.println("No se seleccionó ningún auto. Cancelando reserva.");
            return;
        }

        // 3. Crear y registrar la Reserva
        int idReserva = gdr.obtenerSiguienteId();
        Reserva nuevaReserva = new Reserva(idReserva, cliente, autosElegidos, new Date(), new Date());

        gdr.registrarReserva(nuevaReserva);

        System.out.println("\n¡Reserva creada con éxito con " + autosElegidos.size() + " auto(s)!");
    }

}
