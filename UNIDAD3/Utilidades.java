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

    /**
     * Devuelve la suma desde 1 hasta el numero que recibe
     * Funcion recursiva, en cada caso se puede utilizar la misma funcion con un
     * tamaño menor
     * es decir para suma(5) es igual a suma(4) + 5, para suma(num) es igual a
     * suma(num-1)+num
     * El caso base es cuando directamente se devuelve un valor, en este caso si
     * recibimos 0 o 1
     * 
     * @param num
     * @return
     */
    public static int sumaFactorial(int num) {
        if (num == 1)
            return 1;
        if (num == 0)
            return 0;

        return sumaFactorial(num - 1) + num;
    }

    public static long factorialPares(int num) {
        if (num == 0)
            return 1;
        if (num == 1)
            return 0;
        if (num % 2 != 0)
            num = num - 1;

        return num * factorialPares(num - 2);

    }

    // TODO SUBIRNOTA
    /* Funcion recursiva que calcule el máximo de un array */

}
