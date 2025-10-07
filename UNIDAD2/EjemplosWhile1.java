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
         * Ejerciciov2: leer las edades de 10 personas, que deben de
         * estar entre 18 y 65, se debe de sacar por pantalla la edad y si esta jubilado
         * o si es menor de edad
         * y al final calcular la media
         */

        int edad = 0;
        int sumaEdad = 0;
        int cantidadPersonas = 0;
        i = 1;
        String mensaje = "";
        // Quiero que se repita 10 veces
        while (i <= 10) {
            // Borramos el mensaje de la anterior repeticion
            mensaje = "";
            // Genero la edad aleatoriamente entre 1 y 100
            edad = (int) (Math.random() * 100) + 1;

            if (edad < 18)
                mensaje = "La persona es menor de edad";
            else if (edad > 65)
                mensaje = "Esta jubilado";
            else {

                // Incrementamos la edad con la edad de la persona actual
                sumaEdad = sumaEdad + edad;
                // Incrementamos la cantidad de personas entre 18 y 65 para hacer la media
                cantidadPersonas = cantidadPersonas + 1;
            }

            // Mostramos la edad del personaje
            mensaje = "La edad de la persona " + i + " es: " + edad + ". " + mensaje;
            System.out.println(mensaje);
            // Pasamos a la siguiente persona
            i++;
        }
        // Calculalmos la media
        if (cantidadPersonas != 0)
            sumaEdad = sumaEdad / cantidadPersonas;
        System.out.println("La Media es: " + sumaEdad);

    }
}
