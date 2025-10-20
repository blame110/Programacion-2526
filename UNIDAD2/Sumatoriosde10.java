package UNIDAD2;

/**
 * Sacar por pantalla el sumatorio de todos los números desde 1 hasta 10,
 * siguiendo el siguiente patron
 * suma hasta 1= 1
 * suma hasta 2 = 1+2 =3
 * suma hasta 3 = 1+2+3 = 6
 * ...
 * 
 */
public class Sumatoriosde10 {

    public static void main(String[] args) {

        int suma = 0;

        for (int i = 1; i < 11; i++) {
            System.out.print("La Suma de " + i + ": 1+");
            // Para cada calculo de sumatorio reseteamos la suma anterior
            suma = 1;
            // Para cada valor de i vamos a realizar la suma
            // desde 1 hasta i
            for (int j = 2; j <= i; j++) {

                // Vamos mostrando todos los numeros que se suman
                System.out.print(j);
                // Mostramos un signo despues de cada número
                // Excepto el último que ya no va a tener más numeros detras
                if (j != i)
                    System.out.print("+");
                // Vamos sumando en la variable suma
                // Los valores de j que van desde 1 hasta la i actual
                suma = suma + j;
            }

            System.out.println(" = " + suma);

        }

    }

}
