package UNIDAD3;

public class PruebaValorant {

    public static void main(String[] args) {

        Arma punial = new Arma("Puñal", 2, Arma.CORTA_DISTANCIA, 10,true);
        Arma vandal = new Arma("Vandal", 5, Arma.LARGA_DISTANCIA, 100,true);
        Arma granada = new Arma("Granada", 1, Arma.EXPLOSIVA, 200,true);

        Personaje richton = new Personaje("Ritchton", 100, 0, 0);
        Personaje chapper = new Personaje("Chaper", 40, 20, 0);
        Personaje racer = new Personaje("Racer", 100, 0, 0);

        chapper.getListaArmas().addAll(new ArrayList<Armas> punial,vandal,granada);

    }
}
