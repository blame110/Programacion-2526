package UNIDAD2;

import java.util.Scanner;

public class Buscaminas {
    public static void main(String[] args) {

        /**
         * Definimos el mapa del buscaminas de 3x3
         * De cara a entenderlo se puede interpretar que cada elemento del primer
         * corchete
         * Es a su vez un array, es decir mapa[0] no es un numero sino un array de
         * numeros
         * Para hundir la flota es igual pero de caracteres y 8 posiciones
         */
        int[][] mapaBombas = { { 0, 0, 1 },
                { 0, 1, 0 },
                { 0, 0, 0 } };

        Scanner teclado = new Scanner(System.in);

        System.out.println("En que posiciones quieres comprobar (x y)");
        int posx = teclado.nextInt();
        int posy = teclado.nextInt();
        // Variable para contar las bombas
        int cantBombas = 0;

        // Si hay una bomba en esa posicion explota y se acabo, haber usado un robot o
        // un perro no el dedo
        if (mapaBombas[posy][posx] == 1)
            System.out.println("BOOOOOOOMBA");
        else {
            /**
             * Recorremos con la i las posiciones anteriores y posteriores a la introducida
             * (pox)
             * y con la j las verticales anteriores y posteriores
             */
            for (int i = posx - 1; i <= posx + 1; i++) {
                for (int j = posy - 1; j <= posy + 1; j++) {

                    // Comprobamos si las coordenadas estan dentro del mapa
                    if (i >= 0 && i <= 2 && j >= 0 && j <= 2)
                        // Si en la coordenadas i j hay un 1 implica que hay una bomba
                        // Incrementamos la cantidad de bombas
                        if (mapaBombas[j][i] == 1) {
                            cantBombas++;
                        }
                }
            }
            System.out.println("Cerca de esa posicion (" + posx + "," + posy + ") hay " + cantBombas + " Bombas");

        }

        teclado.close();

    }
}
