
// Jesús Palma González
/**
 * 
a) double calcularValorTotalColeccion() (1,0 puntos)
Calcula la suma del precioActual de todos los juegos en la exposición. Devuelve 0.0 si no hay juegos.
b) ArrayList<JuegoRetro> buscarJuegosPorConsolaYRangoPuntuacion(String consola, double minPuntuacion, double maxPuntuacion) (1,5 puntos)
Devuelve lista de juegos de la consola especificada con puntuacionCritica dentro del rango [minPuntuacion, maxPuntuacion] (inclusive). Validaciones: minPuntuacion ≥ 0, maxPuntuacion ≤ 10, maxPuntuacion ≥ minPuntuacion. Si falla validación, devuelve ArrayList vacío (no null).
c) int cantidadJuegosBaratos(String consola) (1,0 puntos)
OBLIGATORIO USAR STREAMS
Determina la cantidad de juegos de la consola especificada de menos de 10 euros. 
d) int eliminarJuegosPorTipo(int tipoEliminar) (1,0 puntos)
Elimina todos los juegos del tipo especificado. Actualiza la lista y devuelve cuántos juegos se eliminaron. Si no se eliminó ninguno, devuelve 0.
e) JuegoRetro juegoMejorValoracionConCaracteristica(String caracteristicaBuscada) (0,5 puntos)
Devuelve el juego con mayor puntuacionCritica que contenga la característica buscada (insensible a mayúsculas/minúsculas). Si hay empate, devuelve el primero. Si no hay coincidencias, devuelve null.

 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import UNIDAD3.examen.JuegoRetro;

public class ExposicionRetro {

    private int idExposicion;
    public String nombreEvento;
    private ArrayList<JuegoRetro> juegosExhibidos;
    private String localizacion;
    private int entradasVendidas;
    private double precioEntradas;
    private boolean esCompetitivo;

    Random rand = new Random();

    public ExposicionRetro() {
        this.idExposicion = 1000 + rand.nextInt(9000);
        this.nombreEvento = "";
        this.juegosExhibidos = null;
        this.localizacion = "";
        this.entradasVendidas = rand.nextInt(5001);
        this.precioEntradas = 10 + rand.nextDouble(40);
        this.esCompetitivo = false;
    }

    public ExposicionRetro(String nombreEvento, ArrayList<JuegoRetro> juegosExhibidos, String localizacion,
            boolean esCompetitivo) {
        this.idExposicion = 1000 + rand.nextInt(9000);
        this.nombreEvento = nombreEvento;
        this.juegosExhibidos = juegosExhibidos;
        this.localizacion = localizacion;
        this.entradasVendidas = rand.nextInt(5001);
        this.precioEntradas = 10 + rand.nextDouble(40);
        this.esCompetitivo = esCompetitivo;
    }

    public int getIdExposicion() {
        return idExposicion;
    }

    public void setIdExposicion(int idExposicion) {
        this.idExposicion = idExposicion;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public int getEntradasVendidas() {
        return entradasVendidas;
    }

    public void setEntradasVendidas(int entradasVendidas) {
        this.entradasVendidas = entradasVendidas;
    }

    public double getPrecioEntradas() {
        return precioEntradas;
    }

    public void setPrecioEntradas(double precioEntradas) {
        this.precioEntradas = precioEntradas;
    }

    public ArrayList<JuegoRetro> getJuegosExhibidos() {
        return juegosExhibidos;
    }

    public void setJuegosExhibidos(ArrayList<JuegoRetro> juegosExhibidos) {
        this.juegosExhibidos = juegosExhibidos;
    }

    public boolean getEsCompetitivo(boolean esCompetitivo) {
        return esCompetitivo;
    }

    public void setEsCompetitivo(boolean esCompetitivo) {
        this.esCompetitivo = esCompetitivo;
    }

    /*
     * a) double calcularValorTotalColeccion() (1,0 puntos)
     * Calcula la suma del precioActual de todos los juegos en la exposición.
     * Devuelve 0.0 si no hay juegos.
     */
    public double calcularValorTotalColeccion() {

        if (this.juegosExhibidos == null || this.juegosExhibidos.isEmpty())
            return 0.0;

        double totalPrecio = 0;
        // Recorremos todo el array de juegos
        for (JuegoRetro juego : this.juegosExhibidos) {
            totalPrecio = totalPrecio + juego.getPrecioActual();
        }

        return totalPrecio;
    }

    /**
     * b) ArrayList<JuegoRetro> buscarJuegosPorConsolaYRangoPuntuacion(String
     * consola, double minPuntuacion, double maxPuntuacion) (1,5 puntos)
     * Devuelve lista de juegos de la consola especificada con puntuacionCritica
     * dentro del rango
     * [minPuntuacion, maxPuntuacion] (inclusive). Validaciones: minPuntuacion ≥ 0,
     * maxPuntuacion ≤ 10, maxPuntuacion ≥ minPuntuacion.
     * Si falla validación, devuelve ArrayList vacío (no null).
     */
    public ArrayList<JuegoRetro> buscarJuegosPorConsolaYRangoPuntuacion(String consola, double minPuntuacion,
            double maxPuntuacion) {

        if (this.juegosExhibidos == null || this.juegosExhibidos.isEmpty())
            return new ArrayList<>();

        if (minPuntuacion < 0 || maxPuntuacion > 10 || maxPuntuacion < minPuntuacion)
            return new ArrayList<>();

        ArrayList<JuegoRetro> listaJuego = new ArrayList<JuegoRetro>();
        // Recorremos todo el array de juegos
        for (JuegoRetro juego : this.juegosExhibidos) {
            if (juego.getConsola().equalsIgnoreCase(consola)) {
                if (juego.getPuntuacionCritica() >= minPuntuacion && juego.getPuntuacionCritica() <= maxPuntuacion)
                    listaJuego.add(juego);
            }
        }
        return listaJuego;

    }

    /**
     * c) int cantidadJuegosBaratos(String consola) (1,0 puntos)
     * OBLIGATORIO USAR STREAMS
     * Determina la cantidad de juegos de la consola especificada de menos de 10
     * euros.
     */
    public int cantidadJuegosBaratos(String consola) {
        return (int) this.juegosExhibidos.stream()
                .filter(j -> j.getConsola().equalsIgnoreCase(consola))
                .filter(j -> j.getPrecioActual() < 10).count();

    }

    /*
     * d) int eliminarJuegosPorTipo(int tipoEliminar) (1,0 puntos)
     * Elimina todos los juegos del tipo especificado. Actualiza la lista y devuelve
     * cuántos juegos se eliminaron. Si no se eliminó ninguno, devuelve 0.
     */

    public int eliminarJuegosPorTipo(int tipoEliminar) {
        Iterator it = this.juegosExhibidos.iterator();
        JuegoRetro juego;
        int contador = 0;
        // Mientras haya elementos en el arraylist
        while (it.hasNext()) {
            juego = it.next();
            // Si el tipo es el que recibimos, lo borramos
            if (juego.getTipoJuego() == tipoEliminar) {
                // Lo borramos y contamos un juego mas eliminado
                it.remove();
                contador++;
            }

        }
        return contador;
    }

    /*
     * e) JuegoRetro juegoMejorValoracionConCaracteristica(String
     * caracteristicaBuscada) (0,5 puntos)
     * Devuelve el juego con mayor puntuacionCritica que contenga la característica
     * buscada (insensible a mayúsculas/minúsculas). Si hay empate, devuelve el
     * primero. Si no hay coincidencias, devuelve null.
     */
    public JuegoRetro juegoMejorValoracionConCaracteristica(String caracteristicaBuscada) {
        JuegoRetro juegoMejorValorado = null;
        int maxPuntuacion = Integer.MIN_VALUE;

        // Recorremos todo el array de juegos
        for (JuegoRetro juego : this.juegosExhibidos) {
            if (juego.getCaracteristicasEspeciales().contains(caracteristicaBuscada.toLowerCase())) {
                // Calculo del máximo
                if (juego.getPuntuacionCritica() > maxPuntuacion) {
                    juegoMejorValorado = juego;
                    maxPuntuacion = juego.getPuntuacionCritica();
                }
            }
        }

        return juegoMejorValorado;

    }

}
