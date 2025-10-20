package UNIDAD2;

public class EjemploNumeroMayor {

    /**
     * El programa lee o genera aleatoriamente tres numeros y muestra el mayor de
     * los tres
     * 
     * @param args Son los parametros que se introducen por linea de comandos
     */
    public static void main(String[] args) {

        // Recojo los números por linea de comandos
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);
        int num3 = Integer.parseInt(args[2]);

        System.out.printf("Los numeros son %d, %d y %d \n", num1, num2, num3);

        // Para que el num1 sea el mayor tiene que ser mayor que los otros dos
        if (num1 >= num2 && num1 >= num3) {
            System.out.println("El numero mayor es el primero: " + num1);
        } else {
            if (num2 >= num3) {
                System.out.println("El numero mayor es el segundo: " + num2);
            } else {
                System.out.println("El numero mayor es el tercero: " + num3);
            }

        }
    }

}
