/*
Ejercicio 3

Escribir un programa que ingrese un string y la ruta correspondiente a un archivo de texto y
emita un mensaje indicando si dicho string está o no en el archivo. Por ejemplo en el archivo 
se encuentra el texto “Hoy es viernes y esta soleado”, el usuario ingresa el texto “viernes” 
y la respuesta del programa debe ser que se encuentra el texto en el archivo.
 */
package Ejercicio3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        String ruta = "resources/ejercicio3.txt";
        File archivo = new File(ruta);

        System.out.println("¿Qué frase estas buscando en el texto " + ruta + "?");
        Scanner teclado = new Scanner(System.in);
        String aBuscar = teclado.nextLine();

        try {

            Scanner texto = new Scanner(archivo);

            int contador = 0;

            while (texto.hasNextLine()) {
                String linea = texto.nextLine();
                if (linea.contains(aBuscar)) {
                    contador++;
                }
            }

            if (contador == 1) {
                System.out.println("El texto " + aBuscar + " aparece una sola vez");
            } else {
                System.out.println("El texto " + aBuscar + "aparece " + contador + " veces");
            }

            texto.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: No se pudo abrir el archivo.");
        }
    }
}
