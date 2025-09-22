package UNIDAD1;

import java.util.Scanner;

public class EjemploOperadoresComparacion {
    
    public static void main(String[] args) {
        
        boolean puedeIrDelante = false;

        int altura = 0;

        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce la altura del niño: ");
        //Con esta instruccion leemos un valor entero 
        //de la terminal y se lo asignamos a la variable altura
        altura= teclado.nextInt();

        puedeIrDelante = altura >= 135;

        System.out.println("La condicion puede ir delante es " + puedeIrDelante);

     teclado.close();
    }

}
