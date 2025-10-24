package UNIDAD2;

import java.util.Scanner;

/**
 * El programa simulara el juego de cartas de las 7 y 1/2 primero el jugador
 * sacara cartas
 * hasta que quiera parar, si se pasa de 7 y media directamente pierde
 * Si no pierde entonces juega la banca contra la suma de las cartas del jugador
 * La banca querra siempre más cartas mientras su suma sea menor o igual de 5
 */
public class EjemploSieteyMedia {
    public static void main(String[] args) {

        float carta = 0;
        float sumaJugador = 0;
        float sumaBanca = 0;
        String quiereContinuar = "si";
        Scanner teclado = new Scanner(System.in);

        // Mientras quiere continuar jugando y no se pasa le seguimos echando cartas
        while (quiereContinuar.equalsIgnoreCase("si") && sumaJugador < 7.5f) {
            // Sacamos una carta aleatoria de la baraja.
            carta = (int) (Math.random() * 10 + 1);
            // Es media si sale un 8 un 9 o un 10
            if (carta > 7)
                carta = 0.5f;
            // Sumamos la carta que hemos sacado al conjunto de cartas
            sumaJugador = sumaJugador + carta;

            // Le preguntamos al jugador si quiere seguir
            System.out.println("Ha salido un " + carta + " en total llevas " + sumaJugador);

            // Si se ha pasado le mostramos un mensaje
            // En caso contrario le preguntamos si se atreve a seguir
            if (sumaJugador > 7.5f)
                System.out.println("Te has pasao bacalao, me quedo con tu pasta");
            else {
                System.out.print("Quieres Seguir jugando (Si/No):");
                quiereContinuar = teclado.next();
            }

        }

        // La banca empieza sólo si el jugador no se ha pasado
        if (sumaJugador <= 7.5F) {

            // Sacamos cartas para la banca
            while (sumaBanca < 5 && sumaBanca < 7.5f) {
                // Sacamos una carta aleatoria de la baraja.
                carta = (int) (Math.random() * 10 + 1);
                // Es media si sale un 8 un 9 o un 10
                if (carta > 7)
                    carta = 0.5f;
                // Sumamos la carta que hemos sacado al conjunto de cartas
                sumaBanca = sumaBanca + carta;

                // Sacamos por pantalla la carta de la banca
                System.out.println("Ha salido un " + carta + " en total la banca lleva " + sumaBanca);

            }
        }

        // Si se ha pasado le mostramos un mensaje
        // En caso contrario le preguntamos si se atreve a seguir
        if (sumaBanca > 7.5f)
            System.out.println("La Banca ha perdido, espera a final de mes para cobrar");
        else {
            // En este el se la banca no se ha pasado
            // Si el jugador tampoco se ha pasado
            if (sumaJugador <= 7.5f) {

                // Comprobamos si el jugador ha ganado
                if (sumaJugador > sumaBanca) {
                    System.out.println("Ha ganado el jugador!!");
                    if (sumaJugador == 7.5f) {
                        System.out.println("Felicidades por Sacar 7.5 te pagamos el doble");
                    }
                } else
                    System.out.println("Ha ganao la banca");

            }
        }

        teclado.close();

    }
}
