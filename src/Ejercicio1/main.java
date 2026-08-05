/*
Ejercicio 1

Usando ArayList escriba un programa que permita hacer altas, bajas, búsqueda y recorridos
a. en una lista de enteros 
b.en una lista de objetos Alumno (cree la clase)
 */
package Ejercicio1;

import java.util.ArrayList;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        //a.
        Scanner teclado = new Scanner(System.in);

        System.out.print("¿Cuantos números querés?: ");
        int seleccion = teclado.nextInt();

        if (seleccion > 0) {
            ArrayList<Integer> valores = new ArrayList<Integer>();

            for (int i = 0; i < seleccion; i++) {
                System.out.print("Ingrese número " + (i + 1) + ": ");
                Integer aAgregar = new Integer(teclado.nextInt());
                valores.add(aAgregar);
            }

            System.out.println("Lista: " + valores);

            System.out.print("¿Cuál queres eliminar?: ");
            seleccion = teclado.nextInt();

            if (valores.contains(seleccion)) {

                int i = 0;
                boolean encontrado = false;
                while (i < valores.size() && !encontrado) {
                    if (seleccion == valores.get(i)) {
                        valores.remove(i);
                        encontrado = true;
                    } else {
                        i++;
                    }
                }
                System.out.println("Lista luego del borrado: " + valores);
            } else {
                System.out.println("No se encontró el número en la lista." + valores);
            }

        }

        //b.
        System.out.print("¿Cuantos alumnos querés?: ");
        seleccion = teclado.nextInt();

        if (seleccion > 0) {
            ArrayList<Alumno> alumnos = new ArrayList<Alumno>();

            for (int i = 0; i < seleccion; i++) {
                System.out.print("Ingrese nombre del alumno nro " + (i + 1) + ": ");
                String nombre = teclado.next();
                Alumno aAgregar = new Alumno(nombre);
                alumnos.add(aAgregar);
            }

            System.out.println("Lista: " + alumnos);

            System.out.print("¿Cuál queres eliminar? \n INDICAR MEDIANTE EL ID: ");
            int idABuscar = teclado.nextInt();
            
            if (idABuscar > 0 && idABuscar <= alumnos.size()) {
                Alumno aBuscar = alumnos.get(idABuscar-1);
                int i = 0;
                boolean encontrado = false;
                while (i < alumnos.size() && !encontrado) {
                    if (alumnos.get(i) == aBuscar) {
                        alumnos.remove(aBuscar);
                        encontrado = true;
                    } else {
                        i++;
                    }
                }

                System.out.println("Lista luego del borrado: " + alumnos);
            } else {
                System.out.println("No se encontró el Alumno en la lista." + alumnos);
            }
        }

    }

}
