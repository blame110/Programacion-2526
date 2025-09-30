package UNIDAD1;

import javax.swing.JOptionPane;

public class EjemploOperadoresComparacion2 {

    public static void main(String[] args) {

        int numVidas = 0, numNiveles = 0, edadRecomendada = 0;
        String nombreJuego = "Mario Brus";
        char nivelDificultad = 'A';
        String txtEdadRecomendada = "";

        /*
         * Usamos un inputDialog para leer datos, de la libreria visual de java Swing
         * El problema es que solo lee de tipo String
         * Si pasamos con el raton por encima de una función me sale
         * para que es cada parametro y lo que hace
         */
        txtEdadRecomendada = JOptionPane.showInputDialog(null,
                "Introduzca la Edad Recomendada", "Edad Del Juego",
                JOptionPane.QUESTION_MESSAGE);

        /*
         * Supongamos que necesitamos convertir a numero la edadRecomendada
         * Para convertir tipos en java lo más común es usar
         * las funciones parse y valueOf
         */
        edadRecomendada = Integer.valueOf(txtEdadRecomendada);

        System.out.println("Valor de edad usando valueOf " + edadRecomendada);

        // Leemos el nombre del juego
        nombreJuego = txtEdadRecomendada = JOptionPane.showInputDialog(null,
                "Introduzca el nombre del Juego", "Nombre Del Juego",
                JOptionPane.QUESTION_MESSAGE);

        if (edadRecomendada > 18) {
            String mensaje = "Cuidado que es para mayores de edad. ";

            // Para unir (concatenar) cadenas de texto usamos el +
            // Cómo si fuese un número
            mensaje = mensaje + "Ten cuidado!!";

            // Es más rapido usando la funcion concat
            mensaje.concat(" Y no la lies!!");
        }

        int edad = (int) Math.random() * 10;
        String nivelEducativo = "";
        // Usamos else para ejecutar instrucciones en caso
        // de que la condicion no sea cierta
        if (edad > 16)
            nivelEducativo = "BACHILLERATO";
        else
            nivelEducativo = "ESO";

        nivelEducativo = (edad > 16 ? "BACHILLERATO" : "ESO");

        // Para comparar String no se usa el operador == sino la funcion equals
        if (nombreJuego.equals("Mario Bross"))
            System.out.println(
                    "El juego " + nombreJuego + " es el más guay de nintendo y es para mayores de " + edadRecomendada
                            + " años");

        /*
         * Saca el nombre del juego si cumple que su edad recomendada esta entre 5 y 10
         * años
         * y ademas cumple una de las dos siguientes condiciones, que tiene los niveles
         * que leemos por pantalla
         * o que su nivel de difultad es 'C'
         */

    }

}
