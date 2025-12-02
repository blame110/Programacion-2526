package UNIDAD3;

import java.util.Arrays;

public class PruebaValorant {

    public static void main(String[] args) {

        Arma punial = new Arma("Puñal", 2, Arma.CORTA_DISTANCIA, 10, true);
        Arma vandal = new Arma("Vandal", 5, Arma.LARGA_DISTANCIA, 100, true);
        Arma granada = new Arma("Granada", 1, Arma.EXPLOSIVA, 200, true);

        Personaje richton = new Personaje("Ritchton", 100, 0, 0, Personaje.FRANCOTIRADOR);
        Personaje chapper = new Personaje("Chaper", 40, 20, 0, Personaje.FRANCOTIRADOR);
        Personaje racer = new Personaje("Racer", 100, 0, 0, Personaje.FRANCOTIRADOR);

        // Añadimos las armas al personaje con addAll y Arrays.asList
        chapper.getListaArmas().addAll(Arrays.asList(punial, vandal, granada));
        richton.getListaArmas().addAll(Arrays.asList(punial));
        racer.getListaArmas().addAll(Arrays.asList(punial, vandal, granada));

        Gremio pescadores = new Gremio("QuestFisher", 2, chapper);

        pescadores.getMiembros().addAll(Arrays.asList(richton, chapper, racer));

        System.out.println("Este es mi gremio: \n" + pescadores);

        System.out.println("El arma mas pesada de racer es " + racer.armaMasPesada());

        System.out.println("Los Francotiradores mas armados son: " + pescadores.muyArmados(Personaje.FRANCOTIRADOR));

    }
}
