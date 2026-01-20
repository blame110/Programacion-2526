import java.util.ArrayList;
import java.util.Random;

public class JuegoRetro {

    // Jesús Palma González

    /*
     * 1. Clase JuegoRetro.java (1,5 puntos)
     * 
     * Atributos:
     * 
     * codigoJuego: Código único alfanumérico del juego (Ej: "NES-001", "ARC-205").
     * titulo: Título del juego (Ej: "Super Mario Bros", "Street Fighter II").
     * consola: Consola para la que fue diseñado (Ej: "NES", "Arcade",
     * "Mega Drive").
     * anioLanzamiento: Año de lanzamiento (entre 1970 y 2000).
     * precioActual: Precio actual en euros en el mercado de coleccionistas.
     * puntuacionCritica: Puntuación de la crítica (0.0 a 10.0).
     * 
     * tipoJuego: Tipo de juego. Crear constantes estáticas:
     * PLATAFORMAS = 1
     * LUCHA = 2
     * AVENTURAS = 3
     * SHOOTER = 4
     * 
     * esDigital: Indica si es versión digital (true) o física (false).
     * caracteristicasEspeciales: Lista de características especiales separadas por
     * punto y coma (Ej: "Soundtrack original;Manual físico;Figura coleccionista").
     * Puede hacerse como ArrayList o array de Strings si se prefiere.
     */

    private static final int PLATAFORMAS = 0;
    private static final int LUCHA = 1;
    private static final int AVENTURAS = 2;
    private static final int SHOOTER = 3;

    private String codigoJuego;
    public String titulo;
    private String consola;
    private int anioLanzamiento;
    private double precioActual;
    private double puntuacionCritica;
    private int tipoJuego;
    private boolean esDigital;

    private ArrayList<String> caracteristicasEspeciales;

    Random rand = new Random();

    private String calcularIdAlfa() {
        String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char charId;
        String stringId = "";

        for (int i = 0; i < 3; ++i) {
            charId = alfabeto.charAt(rand.nextInt(26));
            stringId += charId;
        }
        return stringId;
    }

    public JuegoRetro() {
        this.titulo = "";
        this.codigoJuego = calcularIdAlfa() + "-" + (100 + rand.nextInt(900));
        this.consola = "";
        this.anioLanzamiento = 1980 + rand.nextInt(20);
        this.precioActual = 20 + rand.nextDouble(480);
        this.puntuacionCritica = 5 + rand.nextDouble(5);
        this.tipoJuego = rand.nextInt(4);
        this.esDigital = false;
        this.caracteristicasEspeciales = null;
    }

    public JuegoRetro(String titulo, String consola, int anioLanzamiento, double precioActual, double puntuacionCritica,
            int tipoJuego, boolean esDigital, ArrayList<String> caracteristicasEspeciales) {
        this.titulo = titulo;
        this.codigoJuego = calcularIdAlfa() + "-" + rand.nextInt(1000) + 1;
        this.consola = consola;
        this.anioLanzamiento = anioLanzamiento;
        this.precioActual = precioActual;
        this.puntuacionCritica = puntuacionCritica;
        this.tipoJuego = tipoJuego;
        this.esDigital = esDigital;
        this.caracteristicasEspeciales = caracteristicasEspeciales;
    }

    public String getCodigoJuego() {
        return codigoJuego;
    }

    public void setCodigoJuego(String codigoJuego) {
        this.codigoJuego = codigoJuego;
    }

    public String getConsola() {
        return consola;
    }

    public void setConsola(String consola) {
        this.consola = consola;
    }

    public int getAnioLanzamiento() {
        return anioLanzamiento;
    }

    public void setAnioLanzamiento(int anioLanzamiento) {
        this.anioLanzamiento = anioLanzamiento;
    }

    public double getPrecioActual() {
        return precioActual;
    }

    public void setPrecioActual(double precioActual) {
        this.precioActual = precioActual;
    }

    public double getPuntuacionCritica() {
        return puntuacionCritica;
    }

    public void setPuntuacionCritica(double puntuacionCritica) {
        this.puntuacionCritica = puntuacionCritica;
    }

    public int getTipoJuego() {
        return tipoJuego;
    }

    public void setTipoJuego(int tipoJuego) {
        this.tipoJuego = tipoJuego;
    }

    public boolean getEsDigital() {
        return esDigital;
    }

    public void setEsDigital(boolean esDigital) {
        this.esDigital = esDigital;
    }

    public ArrayList<String> getCaracteristicasEspeciales() {
        return caracteristicasEspeciales;
    }

    public void setCaracteristicasEspeciales(ArrayList<String> caracteristicasEspeciales) {
        this.caracteristicasEspeciales = caracteristicasEspeciales;
    }

    @Override
    public String toString() {
        return "\nJuego Retro:\n" +
                "<-\n" +
                "Codigo: <" + codigoJuego + ">\n" +
                "Título: <" + titulo + ">\n" +
                "Consola: <" + consola + ">\n" +
                "Precio: <" + precioActual + ">\n" +
                "Puntuación: <" + puntuacionCritica + ">\n" +
                "Tipo: <" + tipoJuego + ">\n" +
                "Digital: <" + tipoJuego + ">\n" +
                "Características: <" + caracteristicasEspeciales + ">\n" +
                "\n->";
        /*
         * Requisitos:
         * Todos los atributos deben ser privados excepto titulo que es público.
         * Métodos get/set para cada atributo privado.
         * Constructores:
         * Vacío: Genera codigoJuego aleatorio (formato "RET-[número 100-999]"),
         * anioLanzamiento aleatorio (1980-1999), precioActual aleatorio (20.0-500.0),
         * puntuacionCritica aleatorio (5.0-10.0). titulo, consola y
         * caracteristicasEspeciales como cadenas vacías. esDigital a false. tipoJuego
         * aleatorio entre los valores de las constantes.
         * Completo: Recibe todos los parámetros excepto codigoJuego que se autogenera
         * como en el constructor vacío.
         * toString() que devuelva:
         * 
         * 
         * Juego Retro:
         * <-
         ** Código: <codigoJuego>
         ** Título: <titulo>
         ** Consola: <consola> - Año: <anioLanzamiento>
         ** Precio: <precioActual>€
         ** Puntuación: <puntuacionCritica>/10
         ** Tipo: <Plataformas/Lucha/Aventuras/Shooter - según valor>
         ** Digital: <Sí/No>
         ** Características: <caracteristicasEspeciales>
         * ->
         */

    }
}