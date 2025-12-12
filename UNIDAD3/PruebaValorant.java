package UNIDAD3;

import java.time.LocalDate;
import java.util.Arrays;

public class PruebaValorant {

    public static void main(String[] args) {

        Arma punial = new Arma("Puñal", 2, Arma.CORTA_DISTANCIA, 10, true);
        Arma vandal = new Arma("Vandal", 5, Arma.LARGA_DISTANCIA, 100, true);
        Arma granada = new Arma("Granada", 1, Arma.EXPLOSIVA, 200, true);

        Personaje richton = new Personaje("Ritchton", 100, 0, 23, Personaje.FRANCOTIRADOR);
        Personaje chapper = new Personaje("Chaper", 40, 20, 12, Personaje.LADRON);
        Personaje racer = new Personaje("Racer", 100, 0, 200, Personaje.FRANCOTIRADOR);

        // Añadimos las armas al personaje con addAll y Arrays.asList
        chapper.getListaArmas().addAll(Arrays.asList(punial));
        richton.getListaArmas().addAll(Arrays.asList(punial));
        racer.getListaArmas().addAll(Arrays.asList(punial, vandal, granada));

        Gremio pescadores = new Gremio("QuestFisher", 2, chapper);

        Quest gallinas = new Quest("100 rupias", "Gallinas Perdidas", "Busca las gallinas", LocalDate.now(),
                Quest.FACIL);
        Quest CaracolGigante = new Quest("1000 rupias y la mano del hijo del rey", "El Calabozo del Caracol Gigante",
                "Desde tiempos inmemoriales el calabozo del caracol gigante jamas ha sido completado, nadie ha pasado del nivel 3, seras capaz de conseguir la concha magica del caracol",
                LocalDate.now(), Quest.MUELTO);

        // Una vez tenemos un LocalDate, hay muchas funciones para cambiar el dia o el
        // mes etc..
        // En particular .plusYears .PlusDays .minuxMonths... podemos modificar la fecha
        gallinas.getFechaFin().plusYears(1);
        gallinas.getFechaFin().atStartOfDay();
        gallinas.getFechaFin().minusMonths(2);

        Quest caracol = new Quest();

        pescadores.getListaQuests().put("gallinas", gallinas);
        pescadores.getListaQuests().put("caracolGigante", caracol);

        pescadores.getMiembros().addAll(Arrays.asList(richton, chapper, racer));

        System.out.println("Este es mi gremio: \n" + pescadores);

        System.out.println("El arma mas pesada de racer es " + racer.armaMasPesada());

        System.out.println("Los Francotiradores mas armados son: " + pescadores.muyArmados(Personaje.FRANCOTIRADOR));

        System.out.println("La quest de la gallina es" + pescadores.getListaQuests().get("gallinas"));

        // pescadores.getListaQuests().keySet() saca un Set (Similar a una lista pero
        // sin duplicados) de todas las claves
        // pescadores.getListaQuests().values() saca una Collection (Similar a una
        // lista) de todos los valores del HashMap
        if (pescadores.getListaQuests().containsKey("gallina"))
            System.out.println("La quest de gallina esta disponible");
        else
            System.out.println("La quest de gallina no esta disponible");

        System.out.println("Los Ladrones mas armados son: " + pescadores.muyArmadosStream(Personaje.LADRON));

        int sumaGremio = pescadores.getMiembros().stream().mapToInt(p -> p.getCreditos()).sum();
        System.out.println("La suma del dinero de todo el gremio es " + sumaGremio);

        // Subir a todos los personajes del gremio 10 puntos de vidas por hechizo
        // colectivo
        pescadores.getMiembros().stream().forEach(p -> p.setCreditos(p.getCreditos() + 10));

        sumaGremio = pescadores.getMiembros().stream().mapToInt(p -> p.getCreditos()).sum();
        System.out.println("La suma del dinero de todo el gremio después es " + sumaGremio);

        // Funciones interesantes de sorted anymatch sorted

    }
}
