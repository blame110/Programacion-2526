package UNIDAD1;

import java.util.Scanner;

/*
 * EjemploOperadoresComparacion.java
 *
 * Este programa ilustra el uso de operadores de comparación y lógicos en Java.
 * Evalúa condiciones para determinar si un niño puede ir delante en un vehículo
 * y si el personaje Ícaro puede volar o recuperar unas llaves, basándose en múltiples criterios.
 *
 * Funcionalidades:
 * - Solicita la edad y altura de un niño al usuario.
 * - Utiliza operadores lógicos (`||` - OR) para decidir si el niño puede ir delante.
 * - Demuestra la precedencia de operadores lógicos (`&&` - AND, `||` - OR) mediante el caso de Ícaro.
 * - Muestra el uso del operador de negación (`!`).
 * - Incluye comentarios detallados sobre la lógica de las condiciones.
 */
public class EjemploOperadoresComparacion {

    public static void main(String[] args) {

        boolean puedeIrDelante = false;

        // En una linea se pueden declarar varias variables del mismo tipo
        int edad = 0, altura = 0;

        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce la altura del niño: ");
        // Con esta instruccion leemos un valor entero
        // de la terminal y se lo asignamos a la variable altur
        altura = teclado.nextInt();

        System.out.print("Introduce la edad del niño: ");
        edad = teclado.nextInt();

        // La estructura if valora si es cierta o falsa la condicion, en caso de ser
        // cierta
        // Entrara y ejecutara el codigo que tiene entre llaves
        if (altura >= 135 || edad >= 10) {
            System.out.println("El niño puede ir delante");
        }

        // Icaro para poder volar desde la isla de creta hasta atenas necesitaba
        // Pesar menos de 80.5 kg y cumplir una de las siguientes dos condiciones
        // Hacer caso a su padre(boolean) o tener mas de rango 5 en google fit(int)
        float peso = 87;
        int googleFitLvl = 6;
        boolean haceCasoFather = false;

        /*
         * Por defecto en una condicion se hace primero el Y && antes que el O
         * En este ejemplo sino ponemos los parentesis primero haria el && y al final
         * el O de google fit, por lo cual sólo con que cumpla la condicion de googlefit
         * ya seria cierto el if, al poner parentesis forzamos a que primero haga
         * el O y cumpla la lógica del enunciado
         */
        if (peso < 80.5 && (haceCasoFather == true || googleFitLvl > 5))
            System.out.println("Consigue Volar Hasta Atenas! Yuhuuuu");

        // Para volver a por las llaves que se le habían olvidado en el laberinto
        // Tiene que hacer caso a su padre y su peso sea distinto de 90
        // o solo con tener un nivel google Fit mayor a 10 también valdría
        if ((haceCasoFather && peso != 90) || googleFitLvl > 10)
            System.out.println(
                    "Estas alelao pero pudiste volver a por las llaves\n P.d.Que sepas que las alas ya se han fundido y estas atrapado de nuevo");

        if (!haceCasoFather)
            System.out.println("Dedadole le mete una toba");

        teclado.close();
    }

}
