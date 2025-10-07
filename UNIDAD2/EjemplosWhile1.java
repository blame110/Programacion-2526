package UNIDAD2;

public class EjemplosWhile1 {

    public static void main(String[] args) {

        int dado = 10;

        while (dado <= 25) {
            System.out.println("Has sacado " + dado + ". Una tirada pasable, voy a regalarte un punto");
            dado = dado + 1;
        }

        // Creamos un número aleatorio para hacer su tabla de multiplicar
        int numTabla = (int) (Math.random() * 10) + 1;
        int i = 1;
        /*
         * Para sacar la tabla de multiplicar mostramos por pantalla la expresion de
         * cada multiplicacion
         * la variable i la vamos incrementando para usarla en la multiplicacion y que
         * cada
         * vez sea por el siguiente número
         */
        while (i <= 10) {

            System.out.println(numTabla + " x " + i + " = " + (numTabla * i));
            i++;
        }

        /*
         * Ejercicio: leer las edades de 10 personas, que deben de
         * generarse aleatoriamente entre 18 y 65, se debe de sacar por pantalla la edad
         * y al final calcular la media
         */

        int edad = 0;
        int sumaEdad = 0;
        i = 1;

        // Quiero que se repita 10 veces
        while (i <= 10) {
            // Genero la edad aleatoriamente
            edad = 18 + (int) (Math.random() * 48);
            // Mostramos la edad del personaje
            System.out.println("La edad de la persona " + i + " es: " + edad);
            // Pasamos a la siguiente persona
            i++;
            sumaEdad = sumaEdad + edad;

        }
        // Calculalmos la media
        sumaEdad = sumaEdad / 10;
        System.out.println("La Media es: " + sumaEdad);

    }
}
