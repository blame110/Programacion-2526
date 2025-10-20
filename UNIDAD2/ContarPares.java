package UNIDAD2;

/**
 * El programa generara 20 números aleatorios y verficara si son pares o impares
 * mostrará un mensaje del tipo el numero x es par/impar
 * Despues sacaremos la cantidad de cada tipo y el porcentaje
 */
public class ContarPares {

    public static void main(String[] args) {
        // Contadores para la cantidad de numeros pares e impares
        int numPares = 0, numImpares = 0;
        // Creamos un bucle for que se repita 20 veces
        for (int i = 0; i <= 19; i++) {
            // Creamos un numero aleatorio entre 1 y 100
            int numAleatorio = (int) (Math.random() * 100 + 1);
            // Si el resto de la division entera entre 2 es 0 implica que es par
            if (numAleatorio % 2 == 0) {
                System.out.println("El número " + numAleatorio + " es par");
                // Sumar uno al contador de pares
                numPares++;
            } else {
                System.out.println("El número " + numAleatorio + " es impar");
                // Sumar uno al contador de impares
                numImpares++;
            }

        }

        System.out.println("El numero de pares es: " + numPares + " y el numero de impares es: " + numImpares);

        System.out.println("El porcentaje de pares ha sido " + (numPares * 100 / 20));
        System.out.println("El porcentaje de impares ha sido " + (numImpares * 100 / 20));

    }
}
