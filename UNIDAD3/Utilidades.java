package UNIDAD3;

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
}
