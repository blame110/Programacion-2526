package UNIDAD2;

import javax.sql.rowset.spi.SyncResolver;

public class EjemploArrays {

    public static void main(String[] args) {
        // TODO hacer un programa que muestre los calcetines sueltos sin par
        // Comentarios añadidos: este fichero usa arrays y dos tipos de bucles:
        // - for por índice para rellenar el array `numeros` (permite acceder a la
        // posición i y asignar valores).
        // - for-each (for (int numero : numeros)) para procesar cada elemento
        // sin usar índices. En las condiciones se usan comparaciones para
        // calcular máximo, mínimo y suma.
        String[] calcetines = { "marron", "rojo", "verde", "negro", "rojo", "verde" };

        System.out.println("El calcentin que esta en cuarta posicion es " + calcetines[3]);

        System.out.println("Hay " + calcetines.length + " calcetines.");

        // Sobreescribimos el calcetin de la posicion 5
        calcetines[4] = "negro";

        // Creamos un array de numeros aleatorios y calculamos sus estadisticas
        int[] numeros = new int[10];

        // Recorremos todas las posiciones del array y lo rellenamos de numeros como al
        // pavo de navidad
        // Bucle for por índice: itera desde 0 hasta numeros.length-1. Esta forma
        // es útil cuando necesitamos conocer la posición (i) además del valor.
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int) (Math.random() * 100) + 1;
            System.out.println("Numero aleatorio en pos " + i + " es " + numeros[i]);
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;

        /**
         * Estructura for especifica para recorrer arrays
         * para cada elemento del array, repite el codigo de dentro
         * y guarda el valor de la posicion actual en la variable numero
         *
         * Comentario: este for-each no da el índice, solo el valor. Es seguro
         * frente a errores de índice (no hay posibilidad de acceder fuera de
         * rango) y es adecuado para leer/usar valores.
         */
        for (int numero : numeros) {
            // Vamos sumando todos los numeros en sum
            // Al final del bucle tendremos la suma de todos
            sum = sum + numero;

            // Para el maximo tenemos que comprobar si el numero actual es el mayor que el
            // maximo
            if (numero > max) {
                max = numero;
            }

            // El minimo es igual pero al contrario
            if (numero < min) {
                min = numero;
            }

        }

        System.out.println("El numero maximo es " + max);
        System.out.println("El numero minimo es " + min);
        System.out.println("La media es " + (sum / numeros.length));
        System.out.println("La suma total es " + sum);
        System.out.println("El numero total es " + numeros.length);

    }
}
