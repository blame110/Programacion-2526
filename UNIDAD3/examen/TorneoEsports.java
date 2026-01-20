
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.stream.Collectors;

public class TorneoEsports {

    /**
     * a) double calcularDanioPromedioClase(int claseFiltro) (1 punto)
     * Calcula el daño promedio (puntosDanio) de todos los personajes que pertenecen
     * a la clase especificada.
     * Devuelve 0.0 si no hay personajes de esa clase o si el torneo no tiene
     * participantes.
     * b) int contarPersonajesLegendariosConHabilidad(String habilidadBuscada)
     * [OBLIGATORIO USAR STREAMS](1 punto)
     * Cuenta cuántos personajes legendarios poseen la habilidad especificada en su
     * lista de habilidades (búsqueda insensible a mayúsculas/minúsculas).
     * c) ArrayList<PersonajeRPG> obtenerTopPersonajesPorVida(int topN) (1,5 puntos)
     * Devuelve un ArrayList con los topN personajes con más puntos de vida,
     * ordenados de mayor a menor.
     * Si topN es mayor que el número de participantes, devuelve todos los
     * participantes ordenados.
     * Si topN ≤ 0, devuelve un ArrayList vacío.
     * d) PersonajeRPG buscarPersonajeMasFuerteDeGremio(String nombreGremio) (1,5
     * puntos)
     * Busca y devuelve el personaje con mayor puntosDanio que pertenezca al gremio
     * especificado.
     * La búsqueda del gremio debe ser exacta (sensible a mayúsculas).
     * Si no existe ningún personaje de ese gremio, devuelve null.
     * En caso de empate en daño, devuelve el de mayor nivel.
     * 
     * 
     * e) boolean actualizarNivelesYEliminarDebiles(int incrementoNivel, int
     * nivelMinimoSupervivencia) (2 puntos)
     * Incrementa el nivel de todos los personajes en la cantidad especificada (sin
     * superar el nivel 100).
     * Después del incremento, elimina del torneo todos los personajes cuyo nivel
     * final sea menor que nivelMinimoSupervivencia.
     * Actualiza jugadoresRegistrados correctamente.
     * Devuelve true si se eliminó al menos un personaje, false en caso contrario.
     * 
     */

    // ================= ATRIBUTOS =================
    private String codigoTorneo;
    public String nombreTorneo;
    private int jugadoresRegistrados;
    private ArrayList<PersonajeRPG> listaJugadores;
    private String servidorRegion;
    private int poolPremios;
    private int requiereNivelMinimo;
    private boolean esRanked;

    // ================= CONSTRUCTOR VACÍO =================
    public TorneoEsports() {
        this.codigoTorneo = "";
        this.nombreTorneo = "";
        this.jugadoresRegistrados = (int) (Math.random() * 101) + 1;
        this.listaJugadores = new ArrayList<>();
        this.servidorRegion = "";
        this.poolPremios = 0;
        this.requiereNivelMinimo = 1;
        this.esRanked = false;
    }

    // ================= CONSTRUCTOR COMPLETO =================
    public TorneoEsports(String codigoTorneo, String nombreTorneo, int jugadoresRegistrados,
            ArrayList<PersonajeRPG> listaJugadores, String servidorRegion, int poolPremios,
            int requiereNivelMinimo, boolean esRanked) {
        this.codigoTorneo = codigoTorneo;
        this.nombreTorneo = nombreTorneo;
        this.jugadoresRegistrados = listaJugadores.size();
        this.listaJugadores = listaJugadores;
        this.servidorRegion = servidorRegion;
        this.poolPremios = poolPremios;
        this.requiereNivelMinimo = requiereNivelMinimo;
        this.esRanked = esRanked;
    }

    // ================= GETTERS Y SETTERS =================

    public String getCodigoTorneo() {
        return codigoTorneo;
    }

    public void setCodigoTorneo(String codigoTorneo) {
        this.codigoTorneo = codigoTorneo;
    }

    public int getJugadoresRegistados() {
        return jugadoresRegistrados;
    }

    public void setJugadoresRegistrados(int jugadoresRegistrados) {
        this.jugadoresRegistrados = jugadoresRegistrados;
    }

    public ArrayList<PersonajeRPG> getListaJugadores() {
        return listaJugadores;
    }

    public void setListaJugadores(ArrayList<PersonajeRPG> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }

    public String getServidorRegion() {
        return servidorRegion;
    }

    public void setServidorRegion(String servidorRegion) {
        this.servidorRegion = servidorRegion;
    }

    public int getPoolPremios() {
        return poolPremios;
    }

    public void setPoolPremios(int poolPremios) {
        this.poolPremios = poolPremios;
    }

    public int getRequiereNivelMinimo() {
        return requiereNivelMinimo;
    }

    public void setRequiereNivelMinimo(int requiereNivelMinimo) {
        this.requiereNivelMinimo = requiereNivelMinimo;
    }

    public boolean getEsRanked() {
        return esRanked;
    }

    public void setEsRanked(boolean esRanked) {
        this.esRanked = esRanked;
    }

    // a) ================= FUNCIÓN CALCULAR PROMEDIO DEL DAÑO =================
    public float calcularDanoPromedioClase() {
        // Stream para obtener promedio de valores
        return (float) listaJugadores.stream()
                .mapToDouble(PersonajeRPG::getPuntosDano)
                .average()
                .orElse(0.0);
    }

    /**
     * a) double calcularDanioPromedioClase(int claseFiltro) (1 punto)
     * Calcula el daño promedio (puntosDanio) de todos los personajes que pertenecen
     * a la clase especificada.
     * Devuelve 0.0 si no hay personajes de esa clase o si el torneo no tiene
     * participantes.
     * 
     */

    public double calcularDanioPromedioClase(int claseFiltro) {
        double promedioDanio = 0;
        int cantidadClase = 0;

        // Recorremos todos los personajes
        for (PersonajeRPG p : this.listaJugadores) {
            // Solo sumo el daño de los de la clase que recibimos como parametro
            if (p.getClasePersonaje() == claseFiltro) {
                promedioDanio += p.getPuntosDano();
                cantidadClase++;
            }
        }

        return promedioDanio / cantidadClase;

    }

    /**
     * c) ArrayList<PersonajeRPG> obtenerTopPersonajesPorVida(int topN) (1,5 puntos)
     * Devuelve un ArrayList con los topN personajes con más puntos de vida,
     * ordenados de mayor a menor.
     * Si topN es mayor que el número de participantes, devuelve todos los
     * participantes ordenados.
     * Si topN ≤ 0, devuelve un ArrayList vacío.
     */

    public ArrayList<PersonajeRPG> obtenerTopPersonajesPorVida(int topN) {

        if (this.listaJugadores == null || this.listaJugadores.isEmpty() || topN <= 0)
            return new ArrayList<>();

        return this.listaJugadores.stream()
                .sort(Comparator.comparingInt(PersonajeRPG::getPuntosVida).reversed())
                .limit(topN).collect(Collectors.toCollection(ArrayList::new));

    }

    public ArrayList<PersonajeRPG> obtenerTopPersonajesPorVidav2(int topN) {

        if (this.listaJugadores == null || this.listaJugadores.isEmpty() || topN <= 0)
            return new ArrayList<>();

        ArrayList<PersonajeRPG> listaOrdenada = new ArrayList<PersonajeRPG>();
        ArrayList<PersonajeRPG> listaTemporal = this.listaJugadores.clone();

        // Calculamos topN veces los máximos y los guardamos en un array
        for (int i = 0; i < topN; i++) {

            int maxVida = Integer.MIN_VALUE;
            PersonajeRPG perMaxVida = null;

            // Recorremos todos los personajes
            for (PersonajeRPG p : listaTemporal) {
                if (p.getPuntosVida() > maxVida) {
                    perMaxVida = p;
                    maxVida = p.getPuntosVida();
                }
            }

            // Una vez acaba el bucle tenemos al personaje con mas vida
            // Lo añadimos a nuestra lista
            listaOrdenada.add(perMaxVida);
            listaTemporal.remove(perMaxVida);
        }
        return listaOrdenada;

    }

    /*
     * e) boolean actualizarNivelesYEliminarDebiles(int incrementoNivel, int
     * nivelMinimoSupervivencia) (2 puntos)
     * Incrementa el nivel de todos los personajes en la cantidad especificada (sin
     * superar el nivel 100).
     * Después del incremento, elimina del torneo todos los personajes cuyo nivel
     * final sea menor que nivelMinimoSupervivencia.
     * Actualiza jugadoresRegistrados correctamente.
     * Devuelve true si se eliminó al menos un personaje, false en caso contrario.
     */

    boolean actualizarNivelesYEliminarDebiles(int incrementoNivel, int nivelMinimoSupervivencia) {

        boolean eliminado = false;
        Iteraror it = this.listaJugadores.iterator();

        while (it.hasNext()) {
            PersonajeRPG p = it.next();
            // Incrementamos a todos los personajes el incremento
            p.setNivel(p.getNivel() + incrementoNivel);
            // Si nos hemos pasado de 100 truncamos
            if (p.getNivel() > 100)
                p.setNivel(100);

            // Si su nivel es inferior al de supervivencia lo borramos
            if (p.getNivel() < nivelMinimoSupervivencia) {
                eliminado = true;
                p.remove();
            }

        }

        return eliminado;

    }

}