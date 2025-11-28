package UNIDAD3;

import java.util.ArrayList;
import java.util.Iterator;

public class Utilidades {

    // modificadores tipo_devuelve nombre_funcion (parametros)
    public static int suma(int num1, int num2) {
        int suma = num1 + num2;
        return suma;
    }

    // Funcion suma que recibe un array de int y devuelve la suma
    public static int suma(int[] numeros) {
        int suma = 0;

        for (int numero : numeros) {
            suma = suma + numero;
        }
        return suma;
    }

    public static int suma(ArrayList<Integer> listaNumeros) {
        int suma = 0;

        Iterator<Integer> it = listaNumeros.iterator();
        while (it.hasNext()) {
            suma = suma + it.next();
        }
        /*
         * /
         * for (Integer num: listaNumeros)
         * {
         * suma = suma + num;
         * }
         * for (int i=0;i<listaNumeros.size();i++)
         * {
         * suma = suma + listaNumeros.get(i);
         * }
         */

        return suma;

    }
}
