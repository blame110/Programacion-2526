package UNIDAD2;

import java.util.Scanner;

/* El programa debera dibujar un cuadrado
 * Habra 2 variantes la primera solo un cuadrado de x espacios de lado
 * La segunda igual pero hueco
 */
public class EjemploCuadrado {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int sizeSquare = 0;

        System.out.println("De que tamaño quieres el cuadrado");

        sizeSquare = teclado.nextInt();

        for (int j = 0; j < sizeSquare; j++) {
            // Dibujamos una linea
            for (int i = 0; i < sizeSquare; i++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Versión hueca:");
        System.out.println();

        // Ahora version ahuecada
        for (int j = 0; j < sizeSquare; j++) {
            // Dibujamos una linea
            if (j == 0 || j == (sizeSquare - 1)) {
                for (int i = 0; i < sizeSquare; i++) {
                    System.out.print("*");
                }
            } else {
                System.out.print("*");
                for (int k = 0; k < sizeSquare - 2; k++) {
                    System.out.print(" ");
                }
                System.out.print("*");
            }
            System.out.println();
        }

        teclado.close();

    }
}
