package UNIDAD1;

/*
 * EjemploAleatorios.java
 *
 * Este programa demuestra cómo generar números aleatorios en Java utilizando
 * `Math.random()`. Genera dos edades aleatorias y luego determina el nivel
 * educativo (ESO o BACHILLERATO) basado en una de las edades.
 *
 * Funcionalidades:
 * - Generación de un número aleatorio entre 1 y 25 para la variable `edad`.
 * - Generación de un número aleatorio entre 18 y 25 para la variable `edad2`.
 * - Uso del operador ternario para asignar un nivel educativo.
 * - Impresión de los valores generados y el nivel educativo en la consola.
 */
public class EjemploAleatorios {
    public static void main(String[] args) {

        /**
         * Para generar un número aleatorio usamos la funcion random de la clase Math
         * Eso genera un número aleatorio entre 0 y 1 de tipo float
         * Para que este en el rango que queramos lo multiplicamos por el máximo
         * Le sumamos 1 si queremos que el primer valor aleatorio sea el 1 y el mayor el
         * multiplicado
         * en este caso el 25
         */
        int edad = (int) (Math.random() * 25) + 1;
        int edad2 = 18 + (int) (Math.random() * 8);

        System.out.println("La edad ha salido " + edad);

        System.out.println("La edad interrail " + edad2);

        String nivelEducativo = (edad > 16 ? "BACHILLERATO" : "ESO");

        System.out.println("Estas en " + nivelEducativo);
    }
}
