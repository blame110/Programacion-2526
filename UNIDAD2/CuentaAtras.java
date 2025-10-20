package UNIDAD2;

public class CuentaAtras {

    public static void main(String[] args) {

        /*
         * Primero vamos a hacer un programa que haga una cuenta atras de un cohete
         * Contara desde 10 hasta 1 y despues dira ignicion, cuando sea 3 ademas
         * mostraré el mensaje "preparados" cuando sea 2 "listos" y cuando sea uno
         * "rezad mucho"
         */
        int i = 10;

        /*
         * Al ser cuenta atras vamos a ir restando uno al numero y lo inicializamos a 10
         * Dentro del bucle dependiendo del valor iremos mostrando los mensajes
         * que nos pide el enunciado
         */
        while (i >= 1) {

            if (i == 3)
                System.out.println("Quedan 3 --- preparados");
            else if (i == 2)
                System.out.println("Quedan 2 --- listossss");
            else if (i == 1)
                System.out.println("Quedan 1 --- rezad todo lo que sepais, inconscientes");
            else
                System.out.println(i);
            i--;
        }

        System.out.println("Zero Ingincionnn!!!");

    }

}
