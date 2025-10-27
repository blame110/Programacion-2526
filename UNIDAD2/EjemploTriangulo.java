package UNIDAD2;

import java.util.Scanner;

//El programa leera la base y dibujara un triangulo de ese tamaño
//Primero versión Rectangulo y luego isosceles
public class EjemploTriangulo {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        int baseTriangulo = 0;

        System.out.println("Dime de que tamaño es la base del triángulo: ");
        baseTriangulo = teclado.nextInt();

        // Dibujamos cada nivel del triangulo, en total hay baseTriangulo veces niveles
        for (int i = 0; i < baseTriangulo; i++) {
            // En cada nivel tengo que dibujar i+1 asteriscos
            for (int j = 0; j < i + 1; j++) {
                // Dibujamos la cantidad de asteriscos de este nivel
                System.out.print("*");
            }
            // Despues de dibujar un nivel, pasamos a la siguiente linea
            System.out.println();
        }

        teclado.close();
    }
}
