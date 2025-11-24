package UNIDAD1;

/*
 * EjemploInicial.java
 *
 * Este programa es una introducción básica a la declaración y uso de variables en Java.
 * Muestra diferentes tipos de datos como enteros (`int`), números decimales (`float`, `double`),
 * cadenas de texto (`String`), caracteres (`char`) y booleanos (`boolean`).
 *
 * Funcionalidades:
 * - Declaración de variables de tipo `int`, `float`, `double`, `String`, `char` y `boolean`.
 * - Asignación de valores a las variables.
 * - Realización de una operación aritmética simple (`edadInicial + 20`).
 * - Impresión de un mensaje de bienvenida en la consola.
 */
public class EjemploInicial {

  public static void main(String args[]) {

    /*
     * Las variables son nombres a los cuales podemos asignar datos
     * Tenemos que definir el tipo de dato que se le va a asignar
     * El nombre debe dejar claro cual es el dato que va a guardar
     * 
     */

    // Para definir variables ponemos el tipo de dato que va a guardar
    // Y despues el nombre de la variable que lo definimos nosotros
    int edad = 0;
    int edadInicial = 12;
    int edadPadres;

    edad = 29;

    edad = edadInicial + 20;
    // Variables de tipo decimal
    float peso = 234.3f;
    double pi = 3.149237856;

    pi = 23424;
    peso = 45;

    // Cadenas de texto y Caracteres
    String nombre = "Juan Pedro";
    char letraInicial = 'J';

    // Boolean
    boolean esPadre = true;

    // Aqui se escribe el codigo del programa
    System.out.print("Bienvenido al curso 2526 de Programación!!");

  }

}
