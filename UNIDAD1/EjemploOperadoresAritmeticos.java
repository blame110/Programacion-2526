package UNIDAD1;

/*
 * EjemploOperadoresAritmeticos.java
 *
 * Este programa demuestra el uso de los operadores aritméticos básicos en Java,
 * incluyendo suma, resta, división, multiplicación, módulo y operadores de asignación
 * compuestos (+=, ++).
 *
 * Funcionalidades:
 * - Realiza operaciones de suma, resta, división y multiplicación con variables enteras.
 * - Calcula el resto de una división utilizando el operador módulo (%).
 * - Demuestra el uso del operador de asignación `+=`.
 * - Muestra la diferencia entre los operadores de pre-incremento (`++variable`)
 *   y post-incremento (`variable++`).
 * - Imprime los resultados de las operaciones en la consola.
 */
public class EjemploOperadoresAritmeticos {

    public static void main(String[] args) {

        int edadHijo = 9;
        int edadPadre = 37;

        int sumaEdades = 0;

        sumaEdades = edadHijo + edadPadre;
        int diferenciaEdades = edadPadre - edadHijo;
        int media = sumaEdades / 2;
        int dobleHijo = edadHijo * 2;
        // El operador % es el resto de la division entera, en este caso
        // 33/5 son 6 y sobra 3, por lo cual resto valdría 3
        int resto = 33 % 5;

        System.out.println("La suma de las edades es: " + sumaEdades);
        System.out.println("La distancia de las edades es: " + diferenciaEdades);
        System.out.println("La media de las edades es: " + media);
        System.out.println("El doble de la edad del hijo es : " + dobleHijo);

        /*
         * Las dos instrucciones siguientes son iguales, el operador +=
         * hace que se le sume lo que haya en la parte derecha
         */
        edadHijo = edadHijo + 10;
        edadHijo += 10;

        edadPadre = edadPadre + 1;

        System.out.println("Edad del Padre: " + edadPadre++);
        System.out.println("Edad del Padre v2: " + ++edadPadre);

    }

}
