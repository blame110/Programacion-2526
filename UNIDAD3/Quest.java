package UNIDAD3;

import java.time.LocalDate;

public class Quest implements Comparable<Quest> {

    public static final int FACIL = 1;
    public static final int MEDIO = 2;
    public static final int DIFICIL = 3;
    public static final int MUELTO = 4;

    private String recompensa;
    private String nombre;
    private String descripcion;
    private LocalDate fechaFin;
    private int dificultad;

    // TODO Hacer el constructor vacio y el que recibe todos los parametros de quest
    public Quest() {

    }

    public Quest(String recompensa, String nombre, String descripcion, LocalDate fechaFin, int dificultad) {

        this.recompensa = recompensa;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaFin = fechaFin;
        this.dificultad = dificultad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDificultad() {
        return dificultad;
    }

    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(String recompensa) {
        this.recompensa = recompensa;
    }

    @Override
    public String toString() {
        String nivelDificultad;

        // Convertir el número de dificultad a texto
        switch (dificultad) {
            case FACIL:
                nivelDificultad = "Fácil";
                break;
            case MEDIO:
                nivelDificultad = "Medio";
                break;
            case DIFICIL:
                nivelDificultad = "Difícil";
                break;
            case MUELTO:
                nivelDificultad = "Muy Difícil";
                break;
            default:
                nivelDificultad = "Desconocido";
        }

        return "╔══════════════════════════════════════╗\n" +
                "║            🎮 QUEST                  ║\n" +
                "╠══════���═══════════════════════════════╣\n" +
                "║ Nombre: " + nombre + "\n" +
                "║ Descripción: " + descripcion + "\n" +
                "║ Dificultad: " + nivelDificultad + "\n" +
                "║ Fecha Fin: " + fechaFin + "\n" +
                "║ Recompensa: " + recompensa + "\n" +
                "╚══════════════════════════════════════╝";
    }

    @Override
    public int compareTo(Quest otraQuest) {
        // Compara por dificultad
        // Retorna: negativo si this < otra, 0 si iguales, positivo si this > otra
        return this.dificultad - otraQuest.dificultad;
    }

}
