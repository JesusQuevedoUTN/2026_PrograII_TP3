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

    public MenuPrincipal() {
        this.libreria = new Libreria();
        this.sc = new Scanner(System.in);
    }

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
                    registrarProveedor();
                    break;

                case 3:
                    Libro aBuscar = buscarLibro();
                    if (aBuscar != null) {
                        System.out.println(aBuscar.toString());
                    }
                    break;

                case 4:
                    Libro aVender = buscarLibro();
                    if (aVender != null) {
                        try {
                            aVender.vender();
                            libreria.guardarEnArchivo();
                            System.out.println("Libro vendido con éxito.");
                        } catch (IllegalStateException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;

                case 5:
                    //realizarEncargo();
                    break;

                case 6:
                    libreria.mostrarLibros();
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

        int seleccion = 1;
        ArrayList autores = new ArrayList();
        do {
            System.out.print("Ingrese autor: ");
            String autor = sc.nextLine();
            autores.add(autor);
            System.out.print("¿Desea agregar otro autor? 1. SI\t 0.NO ");
            seleccion = Integer.parseInt(sc.nextLine());
        } while (seleccion == 1);

        System.out.print("Editorial: ");
        String editorial = sc.nextLine();
        System.out.print("Año de edicion: ");
        int anio = Integer.parseInt(sc.nextLine());

        System.out.print("¿Tapa dura o blanca? 1. DURA\t 0.BLANDA ");
        int opcion = Integer.parseInt(sc.nextLine());
        TipoDeTapa tapa = (opcion == 1) ? TipoDeTapa.TAPA_DURA : TipoDeTapa.TAPA_BLANDA;

        System.out.print("Stock inicial: ");
        int stock = Integer.parseInt(sc.nextLine());

        System.out.print("¿Qué tipo de libro es? (1: NOVELA / 2: TÉCNICO): ");
        int tipoLibro = Integer.parseInt(sc.nextLine());

        Libro nuevoLibro = null;

        if (tipoLibro == 1) {
            nuevoLibro = crearNovela(isbn, titulo, autores, editorial, anio, tapa, stock);
        } else {
            nuevoLibro = crearLibroTecnico(isbn, titulo, autores, editorial, anio, tapa, stock);
        }

        libreria.agregarLibro(nuevoLibro);

        System.out.println("Libro registrado con exito.");
    }

    private void registrarProveedor() {
        System.out.print("Ingrese nombre de la marca: ");
        String nombre = sc.nextLine();
        int seleccion = 1;
        ArrayList editoriales = new ArrayList();
        do {
            System.out.print("Agregar editorial: ");
            String titulo = sc.nextLine();
            editoriales.add(titulo);
            System.out.print("Desea agregar otra editorial? 1. SI\t 0.NO ");
            seleccion = Integer.parseInt(sc.nextLine());
        } while (seleccion == 0);

        Proveedor proveedor = new Proveedor(nombre, editoriales);
        libreria.agregarProveedor(proveedor);
        System.out.println("Editorial registrada con exito.");
    }

    private Novela crearNovela(String isbn, String titulo, ArrayList<String> autores,
            String editorial, int anio, TipoDeTapa tapa, int stock) {
        System.out.println("Seleccione Categoría de Novela:");
        System.out.println("1. CIENCIA FICCIÓN | 2. ROMANCE | 3. MISTERIO | 4. JUVENIL | 5. POLICIAL");
        int opc = Integer.parseInt(sc.nextLine());

        CategoriaNovela cat = CategoriaNovela.CIENCIA_FICCION; // Valor por defecto
        switch (opc) {
            case 2 ->
                cat = CategoriaNovela.ROMANCE;
            case 3 ->
                cat = CategoriaNovela.MISTERIO;
            case 4 ->
                cat = CategoriaNovela.JUVENILES;
            case 5 ->
                cat = CategoriaNovela.POLICIALES;
        }

        return new Novela(isbn, titulo, autores, editorial, anio, tapa, stock, cat);
    }

    private LibroTecnico crearLibroTecnico(String isbn, String titulo, ArrayList<String> autores,
            String editorial, int anio, TipoDeTapa tapa, int stock) {
        System.out.println("Seleccione Categoría Técnica:");
        System.out.println("1. INGENIERÍA | 2. CIENCIAS NATURALES | 3. CIENCIAS SOCIALES");
        int opc = Integer.parseInt(sc.nextLine());

        CategoriaTecnico cat = CategoriaTecnico.INGENIERIA; // Valor por defecto
        switch (opc) {
            case 2 ->
                cat = CategoriaTecnico.CIENCIAS_NATURALES;
            case 3 ->
                cat = CategoriaTecnico.CIENCIAS_SOCIALES;
        }

        return new LibroTecnico(isbn, titulo, autores, editorial, anio, tapa, stock, cat);
    }

    private Libro buscarLibro() {
        System.out.print("ISBN a buscar: ");
        String isbn = sc.nextLine();
        return libreria.buscarLibro(isbn);
    }
}
