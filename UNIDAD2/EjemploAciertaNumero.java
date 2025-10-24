package UNIDAD2;

import java.util.Scanner;

/**
 * Programa que genera un número aleatorio entre 1 y 100
 * y el usuario tiene que acertar el número, tendrá 5 intentos para acertarlo
 * y se le ira indicando si el número es mayor o menor
 */
public class EjemploAciertaNumero {
    public static void main(String[] args) {
        /**************************************/
        // DECLARACION DE VARIABLES
        /**************************************/
        int numBuscado = (int) (Math.random() * 100) + 1;
        int numJugado = 0;
        int numIntentos = 5;
        boolean encontrado = false;

        // Creamos un objeto de tips Scanner para leer por consola
        Scanner teclado = new Scanner(System.in);

        while (numIntentos > 0 && !encontrado) {
            // leemos por teclado el numero que el inocente del usuario cree que es el
            // cierto
            System.out.println("Prueba Suerte, tienes " + numIntentos + " intentos restantes");
            numJugado = teclado.nextInt();
            // Si el número que ha introducido es el buscado
            if (numJugado == numBuscado) {
                System.out.println("Has acertado. Felicidades te has ganado un perrito piloto!!!");
                encontrado = true; // o opcion break que se sale del bucle
            } else if (numBuscado < numJugado) {
                System.out.println("El numero Buscado es menor.");
            } else {
                System.out.println("El numero Buscado es mayor.");
            }

            // Pasar al siguiente elemento
            numIntentos--;

        }

        // Al final sacamos un mensaje
        if (!encontrado)
            System.out.println("Lo siento, el número era: " + numBuscado);

        teclado.close();

    }
}
