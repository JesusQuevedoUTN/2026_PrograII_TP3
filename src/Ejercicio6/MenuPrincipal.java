package Ejercicio6;

import java.util.ArrayList;
import java.util.Scanner;
/*
Se desea diseñar un programa que 
registre, y persista en archivos, libros (técnicos y novelas) para una librería 
permita buscarlos
venderlos
verificar su stock.
*/
public class MenuPrincipal {

    private Libreria libreria;
    private Scanner sc;

    public void menu() {
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("\n--- GESTION DE LIBRERIA ---");
            System.out.println("1. Registrar Libro");
            System.out.println("2. Registrar Proveedor");
            System.out.println("3. Buscar Libro");
            System.out.println("4. Vender Libro");
            System.out.println("5. Realizar Encargo");
            System.out.println("6. Ver Stock General");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    registrarLibro();
                    break;
                case 2:
                    //registrarProveedor();
                    break;
                case 3:
                    //buscarLibro();
                    break;
                case 4:
                    //venderLibro();
                    break;
                case 5:
                    //realizarEncargo();
                    break;
                case 6:
                    mostrarStock();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        }
    }

    private void registrarLibro() {
        System.out.print("ISBN: ");
        String isbn = sc.nextLine();
        System.out.print("Titulo: ");
        String titulo = sc.nextLine();
        System.out.print("Editorial: ");
        String editorial = sc.nextLine();
        System.out.print("Año de edicion: ");
        int anio = Integer.parseInt(sc.nextLine());
        System.out.print("Stock inicial: ");
        int stock = Integer.parseInt(sc.nextLine());
        
        //FALTA TAPA/AUTORES/TIPO
        

        System.out.println("Libro registrado con exito.");
    }

    private void mostrarStock() {
        for (Libro l : libreria.getLibros()) {
            System.out.println(l.getTitulo() + " (ISBN: " + l.getIsbn() + ") - Stock: " + l.getStock());
        }
    }
}
