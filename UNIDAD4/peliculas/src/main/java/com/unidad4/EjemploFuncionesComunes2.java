package com.unidad4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class EjemploFuncionesComunes2 {
    public static void main(String[] args) {
        ArrayList<String> lista = new ArrayList<>();
        lista.add("The Last Of Us");
        lista.add("God of War");
        lista.add("Geometry Dash");
        lista.add("Valorant");

        // Por defecto sort ordena de menor a mayor
        Collections.sort(lista);
        Collections.reverse(lista);

        System.out.println(lista);

        ArrayList<Arma> listaArma = new ArrayList<>();
        listaArma.add(new Arma());
        listaArma.add(new Arma());
        listaArma.add(new Arma());
        listaArma.add(new Arma());
        listaArma.add(new Arma());
        listaArma.add(new Arma());
        listaArma.add(new Arma());
        listaArma.add(new Arma());
        /*
         * Con esta expresion ordenamos el ArrayList de mas danio a menos
         * Con la expresion landa, en este ejemplo si es menor que 0 se ordenara de
         * menor a mayor
         * Si es mayor que 0 pues lo ordenara de mayor a menor
         */

        Collections.sort(listaArma, (a1, a2) -> a2.getDanio() - a1.getDanio());

        System.out.println(listaArma);

        String primerVideojuego = Collections.min(lista);
        Arma masPesada = Collections.max(listaArma, (a1, a2) -> (int) (a1.getPeso() - a2.getPeso()));

        System.out.println("El arma mas pesada es " + masPesada);
        System.out.println("El videojuego inicial es " + primerVideojuego);

        // StringBuilder para gestion de cadenas
        StringBuilder sb = new StringBuilder("Inicio:\n");

        // Añadimos elementos con append
        sb.append("Primera linea\n");

        sb.insert(7, "Adelante!!");

        System.out.println(sb.toString());
    }
}
