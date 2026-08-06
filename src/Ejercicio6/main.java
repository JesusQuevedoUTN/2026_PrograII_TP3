/*
Ejercicio 6

Se desea diseñar un programa que registre, y persista en archivos, libros 
(técnicos y novelas) para una librería y permita buscarlos, venderlos y 
verificar su stock.

Las novelas se clasifican como de ciencia ficción, romance, misterio, juveniles 
y policiales. Los libros técnicos se clasifican como de ingeniería, ciencias 
naturales o ciencias sociales.

Cada libro tiene un título, uno o más autores, una editorial, un año de edición 
y formato (tapas duras o edición económica). Los libros tienen además un código 
ISBN y capítulos, los que tratan una o más materias (en los técnicos) o es una 
simple división (en las novelas).

La librería obtiene los libros por medio de proveedores que representan a una o 
más editoriales. De cada libro se tiene un stock (que puede ser cero). Al 
venderse un libro, el stock se actualiza. Si un cliente requiere un libro cuyo 
stock es cero, se puede realizar un encargo por parte del cliente. Esto 
significa que se pide el libro a un proveedor de la editorial del libro.


¿Qué te pide?: Armar un sistema de gestión para una librería que maneje dos 
tipos de libros (Novelas y Libros Técnicos) clasificados por géneros/materias 
específicos, con autores, editoriales, ISBN, capítulos y stock. Además, 
interactúa con proveedores.Permite buscar libros, venderlos (lo que actualiza y 
descuenta el stock) y verificar disponibilidad. Si el stock llega a cero y un 
cliente lo pide, se debe gestionar un "encargo" al proveedor correspondiente.
Todo debe persistir en archivos.El objetivo: Aplicar herencia/polimorfismo 
(Libro $\rightarrow$ Novela / Libro Técnico) combinada con lógica de negocios 
real (stock, control de cero unidades, encargos y archivos).
 */
package Ejercicio6;

public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

}
