package UNIDAD2;

import java.util.Scanner;

//El programa leera la base y dibujara un triangulo de ese tamaño
//Primero versión Rectangulo y luego isosceles
public class EjemploTrianguloTwo {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        int baseTriangulo = 0;

        System.out.println("Dime de que tamaño es la base del triángulo: ");
        baseTriangulo = teclado.nextInt();

        // Dibujamos cada nivel del triangulo, en total hay baseTriangulo veces niveles
        for (int i = 0; i < baseTriangulo; i++) {// Cada nivel

            // Dibujamos los espacios en blanco para centrar el triangulo
            for (int x = 0; x < baseTriangulo - (i + 1); x++) {
                System.out.print(" ");
            }

            // En cada nivel tengo que dibujar 1+2*i asteriscos
            for (int j = 0; j < 1 + 2 * i; j++) {// Cada vez que entra dibuja un asterisco
                // Dibujamos la cantidad de asteriscos de este nivel
                System.out.print("*");
            }

            // Despues de dibujar un nivel, pasamos a la siguiente linea
            System.out.println();
        }

        teclado.close();
    }
}
