package UNIDAD3;

public class PruebasCalculadora {

    public static void main(String[] args) {

        System.out.println("La suma de 2 + 2 es: " + Utilidades.suma(2, 2));

        int[] listaNumeros = { 3, 4, 23, 123, 123 };

        System.out.println("La suma de de los elementos del array es: " + Utilidades.suma(listaNumeros));

    }

}
