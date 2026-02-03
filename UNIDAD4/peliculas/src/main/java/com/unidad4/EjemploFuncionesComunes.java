package com.unidad4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class EjemploFuncionesComunes {
    public static void main(String[] args) {
        String frase = "Eli va a la %s, pero a la luna esta a %.2f km  de la %s ehhh?? Es de locosss";
        System.out.println("La luna esta en la posición " + frase.indexOf("luna"));

        String cadena = frase.replaceAll("luna", "Marte");
        System.out.println(cadena);

        String listaPalabras[];
        listaPalabras = frase.split(" ");

        System.out.println("La tercera palabra es " + listaPalabras[2]);

        System.out.println(Arrays.toString(listaPalabras));

        System.out.println(String.format(frase, "luna", 100000f, "tierra"));

        String precioStr = "45.99";
        double precio = Double.parseDouble(precioStr);

        System.out.println("el precio es " + precio);

        LocalDate hoy = LocalDate.now();

        System.out.println("Hoy es: " + hoy.getDayOfWeek());

        System.out.println("Dentro de 8 días será: " + hoy.plusDays(8).getDayOfWeek());

        DateTimeFormatter formato1 = DateTimeFormatter.ofPattern("EEEE, dd 'de' MMMM, 'de' yyyy");

        System.out.println(hoy.plusMonths(3).format(formato1));

        LocalDate fecha = LocalDate.now();
        try {
            String fechaStr = "26/02/2026";
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            fecha = LocalDate.parse(fechaStr, formato);
        } catch (java.time.format.DateTimeParseException pe) {
            System.out.println("Hubo un problema al intentar parsear la fecha");
        }
        System.out.println("Hoy estamos a " + fecha.getDayOfWeek());

    }
}
