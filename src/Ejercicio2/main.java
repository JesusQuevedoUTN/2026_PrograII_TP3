/*
Ejercicio 2

¿Qué es un iterador? (iterator). Muestre cómo se usa, haciendo altas, bajas, recorridos y búsquedas en listas implementadas con ArrayList.
 */
package Ejercicio2;

import Ejercicio1.Alumno;
import java.util.ArrayList;
import java.util.Iterator;

public class main {

    public static void main(String[] args) {
        //Iterador: Es una interfaz que permite moverse por distintos elementos de las estructuras de datos
        //Esta es genérica lo que permite el uso seguro de listas como pilas y colas a las que usualmente
        //se reestringen ciertos datos, es mucho más pesada en consumo de RAM que el resto de colecciones
        //y puede ser vista en las funciones for-each

        ArrayList<Alumno> listaRayada = new ArrayList();
        Alumno al1 = new Alumno("Jesus");
        Alumno al2 = new Alumno("Emanuel");
        Alumno al3 = new Alumno("Quevedo");
        Alumno al4 = new Alumno("Chacon");
        listaRayada.add(al1);
        listaRayada.add(al2);
        listaRayada.add(al3);
        listaRayada.add(al4);

        Iterator<Alumno> it = listaRayada.iterator();

        System.out.println("\nMostrando con for-each");
        for (Alumno a : listaRayada) {
            System.out.println(a.toString());
        }

        System.out.println("\nMostrando con while");
        while (it.hasNext()) {
            Alumno a = it.next();
            System.out.println(a.toString());
        }

        System.out.println("\nRemoviendo el final");
        it.remove();

        for (Alumno a : listaRayada) {
            System.out.println(a.toString());
        }

    }

}
