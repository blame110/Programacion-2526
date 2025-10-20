package UNIDAD2;

import java.util.Scanner;

public class EjemploSwitch {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        int codPostal = 0;

        System.out.println(
                "Introduce los dos primeros dígitos código postal de tu ciudad y te digo la comundad autonoma");
        // Leemos el código postal
        codPostal = teclado.nextInt();

        // Con if seria de la siguiente forma
        // if (codPostal==28) System.out.println("Eres de la comunidad de Madrid");
        // else if (codPostal==8) System.out.println("Eres de la comunidad de
        // Barcelona");
        // ...

        String comunidad = "";
        // Con Switch
        switch (codPostal) {
            case 8:
                comunidad = "Barcelona";
                break;
            case 28:
                comunidad = "Madrid";
                break;
            case 51:
                comunidad = "Ceuta";
                break;
            case 52:
                comunidad = "Melilla";
                break;
            case 1:
                comunidad = "Alava";
                break;
            case 50:
                comunidad = "Zaragoza";
                break;
            case 11:
                comunidad = "Cádiz";
                break;
            default:
                comunidad = "Ninguna parte";
        }

        System.out.println("Eres de la Comunidad de " + comunidad);

        teclado.close();

        // Se genera aleatoriamente un número de la semana entre 1 y 7
        // y se saca si es lunes, martes... o fin de semana para el 6 y el 7

        int dia = (int) (Math.random() * 7 + 1);

        switch (dia) {
            case 1:
                System.out.println("Es Lunes");
                break;
            case 2:
                System.out.println("Es martes");
                break;
            case 3:
                System.out.println("Es Miercoles");
                break;
            case 4:
                System.out.println("Es Jueves");
                break;
            case 5:
                System.out.println("Es Vienes");
                break;
            case 6:
            case 7:
                System.out.println("Es fin de semana");
        }

    }
}